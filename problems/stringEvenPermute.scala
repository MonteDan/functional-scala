object stringEvenPermute {
  def swapPairs(str: String): String = {
    str
      .grouped(2)
      .toList
      .map(_.reverse)
      .mkString("")
  }

  def main(args: Array[String]): Unit = {
    println(
      Iterator
        .continually(scala.io.StdIn.readLine()) // Input reading is opimized to a problem on Hackerrank
        .takeWhile(_ != null)
        .toList
        .tail
        .map(swapPairs)
        .mkString("\n")
    )
  }
}