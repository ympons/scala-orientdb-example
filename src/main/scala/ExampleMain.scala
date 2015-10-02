import com.orientechnologies.orient.core.sql.OCommandSQL
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.blueprints.impls.orient.OrientGraphFactory
import scala.collection.JavaConversions._

/**
 * Created by @ympons on 10/2/15.
 */
object ExampleMain {
  def main(args: Array[String]): Unit = {

    val factory = new OrientGraphFactory("remote:127.0.0.1/GratefulDeadConcerts", "admin", "admin")
    val graph = factory.getNoTx()

    try {
      val songs = graph.getVertices("type", "song")
      println("--Songs--")
      songs.foreach(s => println(s.getProperty("name")))

      // Using JavaConversions to cast OrientDynaElementIterable to Iterable
      val artists: Iterable[Vertex] = graph.command(new OCommandSQL("select * from V where type='artist'"))
        .execute().asInstanceOf[java.lang.Iterable[Vertex]]
      println("--Artists--")
      artists.foreach(a => println(a.getProperty("name")))

    } finally {
      graph.shutdown()
    }
    factory.close()

  }
}
