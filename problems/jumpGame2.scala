import utils.{TestUtils => T}
import utils.Pipeline.Pipe

object JumpGame2 {
  def jump(nums: Array[Int]): Int = {
    def helper(i: Int, goal: Int, steps: Int = 0): Int = {
      if (i == goal) steps
      else if (i + nums(i) >= goal) helper(0, i, steps+1)
      else helper(i+1, goal, steps)
    }
    helper(0, nums.length - 1)
  }

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", nums.mkString(","))
      printf("%-7s %-20s\n", "output:", jump(nums))
      println()
    }
    def testRandom(length: Int): Unit =
      (length |> (T.randomIntArray(_,.4)) |> (_.filter(x=>x>0)) |> test) // Filtering 0 not to risk that testcase is unjumpable

    test(Array(4,3,2,1,1,5))
    test(Array(3,2,4,1,0,3))

    testRandom(20)
    testRandom(50)
    testRandom(10)
  }
}