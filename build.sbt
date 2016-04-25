lazy val root = (project in file(".")).
  settings(
    organization := "com.ithrn",
    name := "elt",
    version := "0.1",
    scalaVersion := "2.11.7"
  )

libraryDependencies += "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11+"
libraryDependencies += "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"

scalacOptions ++= Seq("-feature")
