val ScalaVer = "2.11.8"

lazy val commonSettings = Seq(
  name    := "$name$"
, version := "$version$"
, scalaVersion := "2.11.8"
, libraryDependencies ++= Seq(
    "org.typelevel"  %% "cats"      % "0.7.2"
  , "com.chuusai"    %% "shapeless" % "2.3.2"

  , "org.scalatest"  %% "scalatest" % "3.0.0"  % "test"
  )
, scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:experimental.macros",
      "-unchecked",
      "-Xfatal-warnings",
      "-Xlint",
      "-Yinline-warnings",
      "-Ywarn-dead-code",
      "-Xfuture")
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    initialCommands := "import $name;format="lower,word"$._"
  )
