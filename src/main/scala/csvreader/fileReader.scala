package csvreader 

import scala.collection.mutable.Map
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class fileReader(fileName: String) {

    /** Simple method that parses the input file and counts the number of times each state appears
      * @return a map with the state name as the key and the counts as the value
      */
    def countStates(): Map[String, Int] = {
        val file = io.Source.fromFile(fileName) 
        var m = Map[String, Int]()
        for (line <- file.getLines) {
            var state = line.split(",")(2)
            if (m.contains(state)) {
                m(state) += 1
            } else {
                m(state) = 1
            }
        }
        val future = Future (for ((k, v) <- m) println(s"$k: $v"))
        m
    }
}