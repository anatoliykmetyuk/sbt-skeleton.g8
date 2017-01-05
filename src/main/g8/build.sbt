val ScalaVer = "2.12.1"

val Cats          = "0.8.1"
val Shapeless     = "2.3.2"
val Scalacheck    = "1.13.4"
val KindProjector = "0.9.3"

val ScalacheckMinTests = 1000

lazy val commonSettings = Seq(
  name    := "$name$"
, version := "$version$"
, scalaVersion := ScalaVer
, libraryDependencies ++= Seq(
    "org.typelevel"  %% "cats"       % Cats
  , "com.chuusai"    %% "shapeless"  % Shapeless
  , "org.scalacheck" %% "scalacheck" % Scalacheck  % "test"
  )
, addCompilerPlugin("org.spire-math" %% "kind-projector" % KindProjector)
, scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:experimental.macros",
      "-unchecked",
      // "-Xfatal-warnings",
      "-Xlint",
      // "-Yinline-warnings",
      "-Ywarn-dead-code",
      "-Xfuture")
, testOptions in Test += Tests.Argument(TestFrameworks.ScalaCheck, "-minSuccessfulTests", ScalacheckMinTests.toString, "-workers", "10", "-verbosity", "1")
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    initialCommands := "import $name;format="lower,word"$._"
  )
