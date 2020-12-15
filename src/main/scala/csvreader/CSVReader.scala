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
    val t0 = System.nanoTime()
    m.foreach(println)
    val t1 = System.nanoTime()

    val t2 = System.nanoTime()
    val future = Future {
      m.foreach(println)
    } 
    val t3 = System.nanoTime()

    println(s"Elapsed time w/o threading:  ${t1 - t0}ns")
    println(s"Elapsed time with threading: ${t3 - t2}ns")
}