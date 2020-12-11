package csvreader

import scala.collection.mutable.Map
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/** CSVReader
  * 
  * 
  */
object CSVReader extends App {
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
    m.foreach(println)

    val future = Future {
      m.foreach(println)
    } 
}