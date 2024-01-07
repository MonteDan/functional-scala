package utils

import scala.reflect.ClassTag
import scala.util.Random
import scala.collection.immutable.LazyList

object TestUtils {
  def generateRandomNumber(min: Int = 1, max: Int = 100): Int =
    (new Random).nextInt((max - min) + 1) + min

  def generateRandomIntArray(
      length: Int = 10,
      variance: Double = 1
  ): Array[Int] =
    Array.fill(length)(generateRandomNumber(0, (length * variance).toInt))
  
  def random(): Double = (new Random()).nextDouble()

  def randomNumber(min: Int = 1, max: Int = 100): Int =
    (new Random).nextInt((max - min) + 1) + min

  def randomIntArray(
      length: Int = 10,
      variance: Double = 1
  ): Array[Int] =
    Array.fill(length)(randomNumber(0, (length * variance).toInt))

  def shuffleArray[T: ClassTag](arr: Array[T]): Array[T] =
    Random.shuffle(arr.toList).toArray








  /** Inclusive range type: Range */
  def rangeR(start: Int = 0, end: Int = 10, step: Int = 1): Range =
    (start to end by step)

  /** Inclusive range type: Array */
  def range(start: Int = 0, end: Int = 10, step: Int = 1): Array[Int] =
    (start to end by step).toArray

  /** Inclusive range type: Array */
  def rangeA(start: Int = 0, end: Int = 10, step: Int = 1): Array[Int] =
    range(start, end, step)

  /** Inclusive range type: List */
  def rangeL(start: Int = 0, end: Int = 10, step: Int = 1): List[Int] =
    (start to end by step).toList

  /** Inclusive range type: Iterator */
  def rangeI(start: Int = 0, end: Int = 10, step: Int = 1): Iterator[Int] =
    (start to end by step).iterator

  /** Inclusive range converted to String with .mkString */
  def rangeString(
      start: Int = 0,
      end: Int = 10,
      step: Int = 1,
      separator: String = ",",
      open: String = "",
      close: String = ""
  ): String =
    (start to end by step).mkString(open, separator, close)

  /** Inclusive range type: Set */
  def rangeSet(start: Int = 0, end: Int = 10, step: Int = 1): Set[Int] =
    (start to end by step).toSet

  /** Inclusive range type: Seq */
  def rangeSeq(start: Int = 0, end: Int = 10, step: Int = 1): Seq[Int] =
    (start to end by step).toSeq

  /** Inclusive range type: Map */
  def rangeM(start: Int = 0, end: Int = 10, step: Int = 1): Map[Int, Int] =
    (start to end by step).zipWithIndex.toMap

  /** Inclusive range type: Vector */
  def rangeV(start: Int = 0, end: Int = 10, step: Int = 1): Vector[Int] =
    (start to end by step).toVector

  /** Inclusive range type: IndexedSeq */
  def rangeISeq(start: Int = 0, end: Int = 10, step: Int = 1): IndexedSeq[Int] =
    (start to end by step).toIndexedSeq

  /** Inclusive range type: LazyList */
  def rangeLL(
      start: Int = 0,
      end: Int = 10,
      step: Int = 1
  ): LazyList[Int] =
    (start to end by step).to(LazyList)

  /** Inclusive range type: Stack */
  def rangeStack(
      start: Int = 0,
      end: Int = 10,
      step: Int = 1
  ): scala.collection.mutable.Stack[Int] =
    scala.collection.mutable.Stack((start to end by step): _*)

  /** Inclusive range type: Queue */
  def rangeQ(
      start: Int = 0,
      end: Int = 10,
      step: Int = 1
  ): scala.collection.immutable.Queue[Int] =
    scala.collection.immutable.Queue((start to end by step): _*)

  /** Inclusive range type: BitSet */
  def rangeBSet(
      start: Int = 0,
      end: Int = 10,
      step: Int = 1
  ): scala.collection.immutable.BitSet =
    scala.collection.immutable.BitSet((start to end by step): _*)

}
