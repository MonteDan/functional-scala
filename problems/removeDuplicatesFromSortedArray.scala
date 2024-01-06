import utils.Pipeline.Pipe
import utils.{TestUtils => T}

object RemoveDuplicatesFromSortedArray {

  def removeDuplicates(nums: Array[Int]): Int = {
    def shiftAndReplace(replaceIndex: Int, value: Int): Int = {
      nums(replaceIndex + 1) = value
      replaceIndex + 1 // Returns shifted replaceIndex
    }

    def loopNums(curr: Int = 0, replaceIndex: Int = 0): Int = {
      if (curr >= nums.length)
        replaceIndex + 1
      else if (nums(curr) == nums(replaceIndex))
        loopNums(curr + 1, replaceIndex)
      else
        loopNums(
          curr,
          shiftAndReplace(replaceIndex, nums(curr))
        )
    }

    loopNums()
  }

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int]): Unit = {
      printf("%5s %-20s\n", "CASE:", nums.mkString(","))

      val result = removeDuplicates(nums)
      printf("%5s %-20s\n", "k:", result)
      printf("%5s %-20s\n", "nums:", nums.slice(0, result).mkString(","))
      println() // Empty line to visually separate the testcases
    }
    def testRandom(length: Int = 10): Unit = {
      length |> (T.generateRandomIntArray(_,.5)) |> (_.sorted) |> test
    }

    test(Array(2, 2, 3, 3))
    test(Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))

    testRandom(20)
    testRandom(30)
    testRandom(50)
  }
}
