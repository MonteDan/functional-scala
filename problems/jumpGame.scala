import utils.{TestUtils => T}
import utils.Pipeline.Pipe

object JumpGame {
  def canJump(nums: Array[Int]): Boolean = {
    def helper(goal: Int, i: Int): Boolean = {
      if (i < 0) goal == 0
      else if (i + nums(i) >= goal) helper(i, i - 1)
      else helper(goal, i - 1)
    }
    helper(nums.length - 1, nums.length - 2)
  }

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", nums.mkString(","))
      printf("%-7s %-20s\n", "output:", canJump(nums))
      println()
    }
    def testRandom(length: Int): Unit =
      (length |> (T.randomIntArray(_, 4)) |> test)

    test(Array(4,3,2,1,0,5))
    test(Array(2,2,0,1,4))
    test(Array(3,2,4,1,0,3))
  }
}