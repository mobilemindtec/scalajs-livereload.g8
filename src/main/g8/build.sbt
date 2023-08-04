
ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "$scalaVersion$"
ThisBuild / version := "0.1.0-SNAPSHOT"
 
resolvers ++= Seq(
  "Mobile Mind" at "https://raw.githubusercontent.com/mobilemindtec/m2/master"
)

val laminarVersion = "$laminarVersion$"
val frontrouteVersion = "$frontrouteVersion$"  
val nativeConverterVersion = "0.9.0"  
val javaSecurerandomVersion = "1.0.0"
//val momentVersion = "0.10.9"
//val jqueryVersion = "2.1"

lazy val root = (project in file("."))
  .enablePlugins(ScalaJSPlugin, LiveReloadJSPlugin, CopyFullJSPlugin)
  .settings(
    name := "$name$",
    dist := Some(baseDirectory.value / "public"),
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "com.raquo" %%% "laminar" % laminarVersion,
      "io.frontroute" %%% "frontroute" % frontrouteVersion,
      "org.getshaka" %%% "native-converter" % nativeConverterVersion,
      ("org.scala-js" %%% "scalajs-java-securerandom" % javaSecurerandomVersion) cross CrossVersion.for3Use2_13,
      //("ru.pavkin" %%% "scala-js-momentjs" % momentVersion) cross CrossVersion.for3Use2_13,
      //("org.querki" %%% "jquery-facade" % jqueryVersion) cross CrossVersion.for3Use2_13 excludeAll (
      //  ExclusionRule(organization = "org.scala-js")
      //),
    ),
    copyFullTarget := baseDirectory.value / "public" / "assets" / "js" / "main.js"
  )
