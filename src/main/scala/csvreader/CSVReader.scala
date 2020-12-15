package csvreader

import scala.collection.mutable
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.BufferedSource
import scala.util.{Try, Failure, Success}

/** CSVReader
  * 
  * 
  */
object CSVReader extends App {
  var sourcePath = "people.csv"
  if (args.length > 0)
    sourcePath = args(0)
  val readFile = Try(io.Source.fromFile(sourcePath))
  var m = mutable.Map[String, Int]()
  readFile match {
    case Success(file) => m = countStates(file)
    case Failure(exception) => println("Please pass a valid source path with sbt \"run [sourcePath]\".")
  }
  
  m.foreach(println)

  val future = Future {
    m.foreach(println)
  }

  /** Returns a map of states with their associated counts. */
  def countStates(file: BufferedSource): mutable.Map[String, Int] = {
    var m = mutable.Map[String, Int]()
    for (line <- file.getLines) {
      var state = line.split(",")(2)
      if (m.contains(state))
        m(state) += 1
      else
        m(state) = 1
    }

    m
  }
}