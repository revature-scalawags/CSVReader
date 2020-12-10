package csv

/** CSVReader
  * 
  * 
  */
object CSVreader extends App{
	println("Reading CSV file...")

	val file = io.Source.fromFile("people.csv")

	val headers = Array("Name", "Age", "State")

	//Formatting to divide headers for each item in the CSV into a padded row.
	println(f"${headers(0)}%-10s ${headers(1)}%-10s ${headers(2)}%-10s")

	for (line <- file.getLines) {

		var values = line.split(",")
		// line.split() will split a string into an array based on a delimiter.
		// E.G line.split("+") would split the string: 'Tim+40+Texas' into this array: [Tim, 40, Texas]

		println(f"${values(0)}%-10s ${values(1)}%-10s ${values(2)}%-10s")
		// Divides each CSV column into a padded row.
		// Same thing as this:
		// println(values(0) + ", " + values(1) + ", " + values(2))
		// ^You can uncomment that line and it'll print the same shit without formatting(and with commas)
	}
}
