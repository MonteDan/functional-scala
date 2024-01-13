import utils.Pipeline.Pipe
import utils.{TestUtils => T}

object ProductExceptSelf {
  /**
   * Non-FP version but more memory efficient
   
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
      val result = Array.fill(nums.length)(1)

      for (i <- 1 until nums.length) {
        result(i) = nums(i-1) * result(i-1)
      }

      var postfix = 1
      for (i <- nums.length-1 to 0 by -1) {
        result(i) *= postfix
        postfix *= nums(i)
      }

      return result
    }
  */
  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    def loopNums(index: Int = 0, prefix: Int = 1): Array[Int] =
      if (index == nums.length) Array()
      else
        prefix +: loopNums(index + 1, prefix * nums(index))

    def mapResult(result: Array[(Int, Int)], postfix: Int = 1): Array[Int] =
      if (result.isEmpty) Array()
      else
        mapResult(
          result.init,
          postfix * nums(result.last._2)
        ) :+
          (result.last._1 * postfix)

    (
      loopNums() 
      |> (_.zipWithIndex) 
      |> (mapResult(_, 1))
    )
  }

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", nums.mkString(","))
      printf("%-7s %-20s\n", "output:", productExceptSelf(nums).mkString(","))
      println()
    }

    def testRandom(length: Int): Unit = 
      ((length) |> (T.generateRandomIntArray(_)) |> test)
    

    test(Array(1, 2, 3, 0, 5, 6))
    testRandom(5)
    testRandom(10)
    testRandom(10)
  }
}
