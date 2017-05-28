package example

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

  val service = new Service[Request, Response] {
    def apply(request: Request) = {
      // http://localhost:9990/admin/logging
      log.debug("Received params: " + request.params)
      val response = Response(request.version, Status.Ok)
      // curl -v 'localhost:8889/?message=foo'
      response.contentString = request.params.getOrElse("message", "default")
      Future.value(response)
    }
  }

  def main(): Unit = {
    val server = Http.serve(":8889", service)
    onExit {
      server.close()
    }
    Await.ready(server)
  }
}
