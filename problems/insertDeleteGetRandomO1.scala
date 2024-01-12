import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import utils.{TestUtils => T}
import utils.Pipeline.Pipe

object InsertDeleteGetRandomO1 {
  class RandomizedSet() {
    private val map = HashMap[Int, Int]()
    private val list = ArrayBuffer[Int]()

    private def addToSet(`val`: Int): true = {
      map(`val`) = list.length
      list += `val`
      return true
    }

    private def removeFromSet(`val`: Int, lastElement: Int): true = {
      if (`val` != lastElement) {
        list(map(`val`)) = lastElement
        map(lastElement) = map(`val`)
      }
      list.remove(list.length - 1)
      map -= `val`
      return true
    }

    def insert(`val`: Int): Boolean = 
      if (!map.contains(`val`)) addToSet(`val`)
      else false
    

    def remove(`val`: Int): Boolean = 
      if (map.contains(`val`)) removeFromSet(`val`, list.last)
      else false
    

    def getRandom(): Int =
      if (list.isEmpty)
        -1
      else
        list(T.randomNumber(0, list.length - 1))

  }

  def main(args: Array[String]): Unit = {
    val operations = List("insert", "remove", "getRandom")

    def test(operations: List[String], values: List[Int]): Unit = {
      val testCase = operations.zip(values)
      printf(
        "%-5s %-20s\n",
        "CASE:",
        testCase.map { case (op, value) => s"$op $value" }.mkString(",")
      )
      println("output:")
      val randomizedSet = new RandomizedSet()
      operations.zip(values).foreach { case (operation: String, value: Int) =>
        operation match {
          case "RandomizedSet" => println(s"in: $operation, out: null")
          case "insert" =>
            println(s"in: $operation $value, out: ${randomizedSet.insert(value)}")
          case "remove" =>
            println(s"in: $operation $value, out: ${randomizedSet.remove(value)}")
          case "getRandom" =>
            println(s"in: $operation $value, out: ${randomizedSet.getRandom()}")
        }
      }
      println()
      println()
    }

    def testRandom(size: Int): Unit =
      test(
        List.fill(size)(operations(T.randomNumber(0, 2))),
        List.fill(size)(T.randomNumber(0, (size / 3.toInt)))
      )

    test(
      List(
        "RandomizedSet",
        "insert",
        "remove",
        "insert",
        "getRandom",
        "remove",
        "insert",
        "getRandom"
      ),
      List(-1, 1, 2, 2, -1, 1, 2, -1)
    )

    testRandom(15)
  }
}
