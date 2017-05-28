package example.hello

import com.twitter.finagle.http.{ Request, Response }
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.{ CommonFilters, LoggingMDCFilter, TraceIdMDCFilter }
import com.twitter.finatra.http.routing.HttpRouter

object HelloWorldServerMain extends HelloWorldServer

// https://github.com/twitter/finatra/tree/develop/examples
class HelloWorldServer extends HttpServer {

// https://twitter.github.io/finatra/user-guide/http/server.html#override-default-behavior
//
  override val defaultFinatraHttpPort: String = ":8889"

  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[HelloWorldController]
  }
}
