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
    val stateMap = new fileReader("people.csv")
    stateMap.countStates()
}