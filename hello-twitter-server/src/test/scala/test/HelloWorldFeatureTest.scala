package test

import com.twitter.finagle.http.Status._
import com.twitter.finatra.http.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest
import example.hello.HelloWorldServer

class HelloWorldFeatureTest extends FeatureTest {

  override val server = new EmbeddedHttpServer(new HelloWorldServer)

  test("Server#Say hi") {
    server.httpGet(path = "/hi?name=Bob", andExpect = Ok, withBody = "Hello Bob")
  }

  test("Server#Say hi for Post") {
    server.httpPost(path = "/hi", postBody = """
        {
          "id": 10,
          "name" : "Sally"
        }
        """, andExpect = Ok, withBody = "Hello Sally with id 10")
  }
}
