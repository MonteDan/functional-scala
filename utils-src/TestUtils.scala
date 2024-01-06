package utils

object TestUtils {
  def generateRandomNumber(min: Int, max: Int): Int =
    (new scala.util.Random).nextInt((max - min) + 1) + min

  def generateRandomIntArray(length: Int = 10, variance: Double = 1): Array[Int] =
    Array.fill(length)(generateRandomNumber(0, (length*variance).toInt)) 
}