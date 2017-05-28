package example

import com.twitter.finagle.http.filter.HeadFilter
import com.twitter.finagle.{ Http, Service }
import com.twitter.finagle.http.{ Request, Response, Status }
import com.twitter.server.TwitterServer
import com.twitter.util.{ Await, Future }

object BasicServer extends TwitterServer {
  // http://localhost:9990/admin/
  // Before adding `finagle-stats` to libraryDependencies,
  // you see the following warning messages.
  //
  // WARNING: 1 Lint Error(s) Found
  // Finagle server without metrics
  // For more information, please see the lint page.
  //
  // (Just adding the lib is enough. No need to modify the app code at all.)
  // curl -v localhost:9990/admin/metrics.json | jq .

  // By default, the server doesn't accept HEAD requests
  //
  // E 0528 10:50:47.685 THREAD19: Received response to HEAD request (Request("HEAD /hi", from /0:0:0:0:0:0:0:1:59016)) that contained a static body of length 7. Discarding body. If this is desired behavior, consider adding HeadFilter to your service
  //
  // Need to understand Finagle filters and Service
  // https://twitter.github.io/finagle/guide/ServicesAndFilters.html#services

  val headFilter = new HeadFilter[Request]()

  val echoService = new Service[Request, Response] {
    def apply(request: Request) = {
      // http://localhost:9990/admin/logging
      log.debug("Received params: " + request.params)
      val response = Response(request.version, Status.Ok)
      // curl -v 'localhost:8889/?message=foo'
      response.contentString = request.params.getOrElse("message", "default")
      Future.value(response)
    }
  }
  val service = headFilter.andThen(echoService)

  def main(): Unit = {
    val server = Http.serve(":8889", service)
    onExit {
      server.close()
    }
    Await.ready(server)
  }
}
