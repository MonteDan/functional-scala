object Solution {
    def main(args: Array[String]) = {
        val str1 = scala.io.StdIn.readLine("First string:")
        val str2 = scala.io.StdIn.readLine("Second string:")
        println( 
          str1
            .zipWithIndex
            .toList
            .map{ 
              case (char, index) => char.toString + str2(index).toString
            }.reduce((acc, curr) => acc+curr)
        )
    }
}
