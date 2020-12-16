package csvreader

import scala.collection.mutable.Map
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

import org.mongodb.scala.MongoClient
import org.bson.codecs.configuration.CodecRegistries.{fromProviders, fromRegistries}

/** CSVReader
  * 
  * 
  */
object CSVReader extends App 
{
    val file = io.Source.fromFile("people.csv") 
    var m = Map[String, Int]()
    for (line <- file.getLines) 
    {
      var state = line.split(",")(2)
      if (m.contains(state)) 
      {
        m(state) += 1
      } 
      else 
      {
        m(state) = 1
      }
    }
    m.foreach(println)

    val future = Future 
    {
      m.foreach(println)
    } 

    // val client = MongoClient()
    // val codecRegistry = fromRegistries(fromProviders(classOf[States]), MongoClient.DEFAULT_CODEC_REGISTRY)
    // val db = client.getDatabase("mydb").withCodecRegistry(codecRegistry)

    // val statesdao = db.getCollection("counts").find()
}