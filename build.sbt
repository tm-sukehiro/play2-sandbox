name := """play2Sample"""

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

lazy val commonSettings = Seq(
  version := "1.0",
  organization := "com.github.sample",
  scalaVersion := "2.11.8"
)

lazy val webConsole = (project in file("webConsole"))
  .enablePlugins(PlayScala)
  .dependsOn(swagger)
  .settings(commonSettings)
  .settings(Seq(
    name := "play2Sample-main",
    libraryDependencies ++= Seq(
      jdbc,
      cache,
      ws,
      "jp.t2v" %% "stackable-controller" % "0.6.0",
      "jp.t2v" %% "play2-auth"        % "0.14.2",
      "jp.t2v" %% "play2-auth-social" % "0.14.2",
      "jp.t2v" %% "play2-auth-test"   % "0.14.2" % "test",
      "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
      "mysql" % "mysql-connector-java" % "5.1.36",
      "org.scalikejdbc" %% "scalikejdbc" % "2.4.2",
      "com.h2database" % "h2" % "1.4.192",
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "org.mockito" % "mockito-core" % "1.10.19" % Test
    )
  ))

lazy val swagger = RootProject(uri("ssh://git@github.com/CreditCardsCom/swagger-play.git"))