package test

import com.google.inject.Stage
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import example.hello.HelloWorldServer

class HelloWorldStartupTest extends FeatureTest {

  override val server =
    new EmbeddedHttpServer(twitterServer = new HelloWorldServer, stage = Stage.PRODUCTION, verbose = false)

  test("Server#startup") {
    server.assertHealthy()
  }
}
