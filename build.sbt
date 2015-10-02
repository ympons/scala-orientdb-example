name := "scala-orientdb-example"
version := "1.0"
scalaVersion := "2.11.7"

//Library repositories
resolvers ++= Seq(
  Resolver.mavenLocal,
  "Scala-Tools Maven2 Repository" at "http://scala-tools.org/repo-releases",
  "Java.net repository" at "http://download.java.net/maven/2",
  "Sonatype Nexus Releases" at "https://oss.sonatype.org/content/repositories/releases"
)

val scala_version = "2.11.7"
val orient_version = "2.1.2"
val tinker_version = "2.6.0"

//Library Dependencies
libraryDependencies ++= Seq(
  //Scala
  "org.scala-lang" % "scala-library" % scala_version,
  "org.scala-lang" % "scala-reflect" % scala_version,

  //Tinkerpop
  "com.tinkerpop.gremlin" % "gremlin-java" % tinker_version,
  "com.tinkerpop.blueprints" % "blueprints-core" % tinker_version,
  "com.tinkerpop.blueprints" % "blueprints-test" % tinker_version,
  "com.tinkerpop" % "pipes" % tinker_version,

  //OrientDB
  "com.orientechnologies" % "orientdb-core" % orient_version jar(),
  "com.orientechnologies" % "orientdb-graphdb" % orient_version,
  "com.orientechnologies" % "orientdb-client" % orient_version,
  "com.orientechnologies" % "orientdb-enterprise" % orient_version
)
