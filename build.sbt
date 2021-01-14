
name := "alpakka-streams"

version := "0.1"

scalaVersion := "2.13.4"

lazy val akkaVersion = "2.6.10"
val scalaTestVersion = "3.2.3"

lazy val dependencies = new {
  val akkaVersion             = "2.6.0"
  val alpakkaVersion          = "2.0.2"
  val alpakkaCsvVersion       = "2.0.0-RC2"
  val alpakkaCassandraVersion = "2.0.0"
  val logbackVersion          = "1.2.2"
  val scalaLoggingVersion     = "3.9.2"

  val akkaActors       = "com.typesafe.akka"  %% "akka-actor-typed"              % akkaVersion
  val akkaStreams      = "com.typesafe.akka"  %% "akka-stream"                   % akkaVersion
  val alpakkaKafka     = "com.typesafe.akka"  %% "akka-stream-kafka"             % alpakkaVersion
  val alpakkaCassandra = "com.lightbend.akka" %% "akka-stream-alpakka-cassandra" % alpakkaCassandraVersion
  val alpakkaCsv       = "com.lightbend.akka" %% "akka-stream-alpakka-csv"       % alpakkaCsvVersion


  val logback      = "ch.qos.logback"             % "logback-classic" % logbackVersion
  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging"  % scalaLoggingVersion
}

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("check", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")

libraryDependencies ++= Seq(
  dependencies.akkaActors,
  dependencies.akkaStreams,
  dependencies.alpakkaKafka,
  dependencies.alpakkaCsv,
  dependencies.alpakkaCassandra,

  dependencies.logback
)