
name := "alpakka-streams"

version := "0.1"

scalaVersion := "2.13.4"

lazy val akkaVersion = "2.6.10"
val scalaTestVersion = "3.2.3"

lazy val dependencies = new {
  val akkaVersion             = "2.6.10"
  val alpakkaCassandraVersion = "2.0.2"
  val logbackVersion          = "1.2.2"

  val akkaActors       = "com.typesafe.akka"  %% "akka-actor-typed"              % akkaVersion
  val akkaStreams      = "com.typesafe.akka"  %% "akka-stream"                   % akkaVersion
  val alpakkaCassandra = "com.lightbend.akka" %% "akka-stream-alpakka-cassandra" % alpakkaCassandraVersion
  val logback      = "ch.qos.logback"             % "logback-classic" % logbackVersion

}

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("check", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")

libraryDependencies ++= Seq(
  dependencies.akkaActors,
  dependencies.akkaStreams,
  dependencies.logback,

  //based on suggestion https://github.com/akka/alpakka/issues/2556
  dependencies.alpakkaCassandra
  excludeAll ExclusionRule(organization = "com.datastax.oss"),
  "com.datastax.oss" % "java-driver-core" % "4.10.0",
  "com.esri.geometry" % "esri-geometry-api" % "2.2.4"

)