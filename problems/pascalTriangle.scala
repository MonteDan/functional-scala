object PascalTriangle {

  def factorial(x: Int): Long = 
    if (x <= 1) 1
    else x * factorial(x - 1)

  def pascalValue(column: Int, row: Int): Long =
    factorial(row) / (factorial(column) * factorial(row - column))

  def getPascalRow(row: Int, startAt: Int = 0): String =
    if (startAt <= row)
      pascalValue(startAt, row).toString + " " + getPascalRow(row, startAt + 1)
    else ""

  def main(args: Array[String]): Unit = {
    println("Enter the number of rows for Pascal's Triangle:")
    val numRows = scala.io.StdIn.readInt()

    if (numRows >= 0) {
      println(s"Pascal's Triangle with $numRows rows:")
      (0 until numRows).foreach(row => println(getPascalRow(row).trim))
    } else {
      println("Number of rows should be non-negative.")
    }
  }
}
