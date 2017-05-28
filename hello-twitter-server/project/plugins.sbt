scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

// faster library dependencies resolver
addSbtPlugin("io.get-coursier"  % "sbt-coursier"         % "1.0.0-RC3")

// code formatter
// usage: sbt scalafmt
addSbtPlugin("com.geirsson"     % "sbt-scalafmt"         % "0.6.6")

// utilities for checking library dependencies
// usage: sbt dependencyTree
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
// usage: sbt dependencyUpdates
addSbtPlugin("com.timushev.sbt" % "sbt-updates"          % "0.3.0")

// for building fat jars
// https://github.com/sbt/sbt-assembly
// usage: sbt assembly
addSbtPlugin("com.eed3si9n"     % "sbt-assembly"         % "0.14.4")
