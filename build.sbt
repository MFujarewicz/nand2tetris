import Dependencies._

//ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / scalaVersion     := "3.2.2"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "nand2tetris",
    libraryDependencies += scalaTest % Test
  )

