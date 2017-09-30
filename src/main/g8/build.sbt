val ScalaVer = "2.12.3"

val Cats          = "0.9.0"
val CatsEffect    = "0.3"
val KindProjector = "0.9.4"

$if(shapeless.truthy)$
val Shapeless = "2.3.2"
$endif$

$if(fs2.truthy)$
val FS2 = "0.9.7"
$endif$

val ScalaTest  = "3.0.4"
val ScalaCheck = "1.13.5"

$if(commonsIO.truthy)$
val CommonsIO = "2.5"
$endif$

lazy val commonSettings = Seq(
  name    := "$name$"
, version := "$version$"
, scalaVersion := ScalaVer
, libraryDependencies ++= Seq(
    "org.typelevel"  %% "cats"        % Cats
  , "org.typelevel"  %% "cats-effect" % CatsEffect
    $if(shapeless.truthy)$
  , "com.chuusai"    %% "shapeless"   % Shapeless
    $endif$
    $if(fs2.truthy)$

  , "co.fs2" %% "fs2-core" % FS2
  , "co.fs2" %% "fs2-io"   % FS2
    $endif$

  , "org.scalatest"  %% "scalatest"  % ScalaTest  % "test"
  , "org.scalacheck" %% "scalacheck" % ScalaCheck % "test"

    $if(commonsIO.truthy)$
  , "commons-io" % "commons-io" % CommonsIO
    $endif$
  )

, addCompilerPlugin("org.spire-math" %% "kind-projector" % KindProjector)
, scalacOptions ++= Seq(
      "-deprecation"
    , "-encoding", "UTF-8"
    , "-feature"
    , "-language:existentials"
    , "-language:higherKinds"
    , "-language:implicitConversions"
    , "-language:experimental.macros"
    , "-unchecked"
    // , "-Xfatal-warnings"
      $if(warnUnusedImports.truthy)$
    , "-Xlint"
      $endif$
    // , "-Yinline-warnings"
    , "-Ywarn-dead-code"
    , "-Xfuture"
    , "-Ypartial-unification")
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    initialCommands := "import $name;format="lower,word"$._, Main._"
  )
