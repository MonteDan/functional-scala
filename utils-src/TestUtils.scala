package utils

import scala.reflect.ClassTag
import scala.util.Random

object TestUtils {
  def generateRandomNumber(min: Int = 1, max: Int = 100): Int =
    (new Random).nextInt((max - min) + 1) + min

  def generateRandomIntArray(length: Int = 10, variance: Double = 1): Array[Int] =
    Array.fill(length)(generateRandomNumber(0, (length*variance).toInt)) 
  
  def shuffleArray[T: ClassTag](arr: Array[T]): Array[T] = 
    Random.shuffle(arr.toList).toArray
}