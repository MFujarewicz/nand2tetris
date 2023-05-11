import Dependencies._

ThisBuild / scalaVersion := "2.13.10"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "nand2tetris")

libraryDependencies += scalaTest % Test
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.6"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"



