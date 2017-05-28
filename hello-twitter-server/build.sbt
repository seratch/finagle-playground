lazy val finatraVersion = "2.10.0"

lazy val root = (project in file(".")).settings(
  scalaVersion := "2.12.2",
  transitiveClassifiers in Global := Seq(Artifact.SourceClassifier),
  libraryDependencies ++= Seq(
    "com.twitter" %% "twitter-server" % "1.29.0",
    // https://twitter.github.io/twitter-server/Features.html#metrics
    "com.twitter" %% "finagle-stats" % "6.44.0",
    // https://twitter.github.io/finatra/user-guide/getting-started/basics.html
    "com.twitter"                  %% "finatra-http"       % finatraVersion,
    "com.twitter"                  %% "finatra-httpclient" % finatraVersion,
    "org.scalatest"                %% "scalatest"          % "3.0.3" % "test",
    "com.twitter"                  %% "finatra-http"       % finatraVersion % "test",
    "com.twitter"                  %% "finatra-jackson"    % finatraVersion % "test",
    "com.twitter"                  %% "inject-server"      % finatraVersion % "test",
    "com.twitter"                  %% "inject-app"         % finatraVersion % "test",
    "com.twitter"                  %% "inject-core"        % finatraVersion % "test",
    "com.twitter"                  %% "inject-modules"     % finatraVersion % "test",
    "com.google.inject.extensions" % "guice-testlib"       % "4.0" % "test",
    "org.mockito"                  % "mockito-core"        % "1.9.5" % "test",
    "com.twitter"                  %% "finatra-http"       % finatraVersion % "test" classifier "tests",
    "com.twitter"                  %% "finatra-jackson"    % finatraVersion % "test" classifier "tests",
    "com.twitter"                  %% "inject-server"      % finatraVersion % "test" classifier "tests",
    "com.twitter"                  %% "inject-app"         % finatraVersion % "test" classifier "tests",
    "com.twitter"                  %% "inject-core"        % finatraVersion % "test" classifier "tests",
    "com.twitter"                  %% "inject-modules"     % finatraVersion % "test" classifier "tests",
    "com.google.inject.extensions" % "guice-testlib"       % "4.0" % "test" classifier "tests"
  ),
  /*
  [error] (*:assembly) deduplicate: different file contents found in the following:
  [error] /Users/kazuhirosera/.ivy2/cache/com.twitter/twitter-server_2.12/jars/twitter-server_2.12-1.29.0.jar:BUILD
  [error] /Users/kazuhirosera/.ivy2/cache/com.twitter/finagle-core_2.12/jars/finagle-core_2.12-6.44.0.jar:BUILD
  [error] /Users/kazuhirosera/.ivy2/cache/com.twitter/finagle-http_2.12/jars/finagle-http_2.12-6.44.0.jar:BUILD
  [error] /Users/kazuhirosera/.ivy2/cache/com.twitter/finagle-netty4_2.12/jars/finagle-netty4_2.12-6.44.0.jar:BUILD
  [error] /Users/kazuhirosera/.ivy2/cache/com.twitter/finagle-thrift_2.12/jars/finagle-thrift_2.12-6.44.0.jar:BUILD
  [error] deduplicate: different file contents found in the following:
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-handler/jars/netty-handler-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-buffer/jars/netty-buffer-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-common/jars/netty-common-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-transport/jars/netty-transport-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-resolver/jars/netty-resolver-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-codec/jars/netty-codec-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-transport-native-epoll/jars/netty-transport-native-epoll-4.1.9.Final-linux-x86_64.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-handler-proxy/jars/netty-handler-proxy-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-codec-socks/jars/netty-codec-socks-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-codec-http/jars/netty-codec-http-4.1.9.Final.jar:META-INF/io.netty.versions.properties
  [error] /Users/kazuhirosera/.ivy2/cache/io.netty/netty-codec-http2/jars/netty-codec-http2-4.1.9.Final.jar:META-INF/io.netty.versions.properties
   */
  // https://stackoverflow.com/a/39058507
  assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _ *) => MergeStrategy.discard
    case _                              => MergeStrategy.first
  }
)
