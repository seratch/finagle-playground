scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

// Unfortunately, it doesn't work with test deps for Finagle based projects
// faster library dependencies resolver
//addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC3")

// code formatter
// usage: sbt "~;scalafmt;test:compile"
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.6.6")

// just for preparing seamless IDEA settings (looks still needed)
// usage: sbt genIdea
addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

// https://github.com/spray/sbt-revolver
// usage: sbt "~;scalafmt;reStart"
addSbtPlugin("io.spray" % "sbt-revolver" % "0.8.0")

// for preparing ENSIME configuration
// http://ensime.org/build_tools/sbt/
// usage: sbt ensimeConfig
addSbtPlugin("org.ensime" % "sbt-ensime" % "1.12.12")

// utilities for checking library dependencies
// usage: sbt dependencyTree
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
// usage: sbt dependencyUpdates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.0")

// for building fat jars
// https://github.com/sbt/sbt-assembly
// usage: sbt assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.4")
