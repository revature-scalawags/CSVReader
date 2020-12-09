package csv

/** CSVReader
  * 
  * 
  */
object CSVReader extends App {
    println("State, Count")
    val file = io.Source.fromFile("people.csv")
    for (line <- file.getLines) {
        println(line)        
    }
}