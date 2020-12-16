package csvreader

import scala.collection.mutable.Map
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

import org.mongodb.scala.MongoClient
import org.bson.codecs.configuration.CodecRegistries.{
  fromProviders,
  fromRegistries
}
import com.mongodb.BasicDBObject
import java.util.concurrent.TimeUnit

/** CSVReader
  */
object CSVReader extends App {
  if (args.length > 0) {
    val file = io.Source.fromFile("people.csv")
    var m = Map[String, Int]()
    for (line <- file.getLines) {
      var state = line.split(",")(2)
      if (m.contains(state)) {
        m(state) += 1
      } else {
        m(state) = 1
      }
    }

    val future = Future {
      m.foreach(println)
    }
  }

  val client = MongoClient()
  val db = client.getDatabase("testdb")
  val res = db.getCollection("states").find().first().head()
  Await.result(res, Duration(10, TimeUnit.SECONDS)).foreach(println)
}
