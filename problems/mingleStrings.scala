object MingleStrings {

  def mingle(s1: String, s2: String): String = {
    if ( s1.length()<=1 || s2.length()<=1 ) s1 + s2
    else s1.head.toString + s2.head.toString + mingle(s1.tail, s2.tail)
  }

  def main(args: Array[String]): Unit = {
    val str1 = scala.io.StdIn.readLine("Enter the first string: ")
    val str2 = scala.io.StdIn.readLine("Enter the second string: ")

    println( mingle(str1, str2) )
  }
}
