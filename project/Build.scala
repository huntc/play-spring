import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "play-spring"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.springframework" % "spring-context" % "3.2.2.RELEASE",
    "javax.inject" % "javax.inject" % "1"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
