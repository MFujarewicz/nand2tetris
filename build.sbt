import Dependencies._

ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.fujarewicz"
ThisBuild / organizationName := "fujarewicz"

lazy val root = (project in file("."))
  .settings(
    name := "nand2tetris",
    assembly / assemblyJarName := "VMTranslator.jar",
    assembly / mainClass := Some("vm.Main"),
    assembly / assemblyOutputPath := file(s"week7submission/${(assembly/assemblyJarName).value}")
  )

libraryDependencies += scalaTest % Test
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.6"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"


assembly / assemblyMergeStrategy := {
  case x if x.endsWith("module-info.class") => MergeStrategy.discard
  case x =>
    val oldStrategy = (assembly / assemblyMergeStrategy).value
    oldStrategy(x)
}