scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

addSbtPlugin("io.get-coursier"  % "sbt-coursier"         % "1.0.0-RC3")
addSbtPlugin("com.geirsson"     % "sbt-scalafmt"         % "0.6.6")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
addSbtPlugin("com.timushev.sbt" % "sbt-updates"          % "0.3.0")
