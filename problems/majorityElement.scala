import utils.Pipeline.Pipe
import utils.{TestUtils => T}

object MajorityElement {

  def majorityElement(nums: Array[Int]): Int = {
    def loopNums(curr: Int, result: Int, count: Int = 1): Int = {
      if (curr == nums.length)
        result
      else if (count == 0)
        loopNums(curr + 1, nums(curr))
      else if (nums(curr) == result)
        loopNums(curr + 1, result, count + 1)
      else
        loopNums(curr + 1, result, count - 1)
    }
    loopNums(1, nums(0))
  }

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", nums.mkString(","))
      printf("%-7s %-20s\n", "output:", majorityElement(nums))
      println()
    }
    def halfOfInt(x: Int): Int = x |> (_ / 2) |> (_.toInt)
    def testRandom(length: Int = 10): Unit = {
      (T.generateRandomNumber(max = length)
        |> (Array.fill(
          halfOfInt(length) + 1
        )(_))
        |> (_ ++ T.generateRandomIntArray(halfOfInt(length) - (if (length%2==0) {1} else {0}), 2))
        |> T.shuffleArray
        |> test)
    }

    test(Array(2, 2, 1, 1, 1, 2, 2))

    testRandom(1)
    testRandom(3)
    testRandom(15)
    testRandom(50)
    testRandom(100)


  }
}
