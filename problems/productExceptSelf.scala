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
  def productExceptSelf(nums: Array[BigInt]): Array[BigInt] = {
    def loopNums(index: Int = 0, prefix: BigInt = 1): Array[BigInt] =
      if (index == nums.length) Array()
      else
        prefix +: loopNums(index + 1, prefix * nums(index))

    def mapResult(result: Array[(BigInt, Int)], postfix: BigInt = 1): Array[BigInt] =
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
    def test(nums: Array[BigInt]): Unit = {
      val (output, runtime, memory) = T.measure {
        productExceptSelf(nums)
      }
      printf("%-7s %-20s\n", "CASE:", nums.mkString(","))
      printf("%-7s %-20s\n", "output:", output.mkString(","))
      println(s"$runtime ms, $memory KB")
      println()
    }

    def testRandom(length: Int): Unit = 
      ((length) |> (len => T.generateRandomIntArray(len).map(BigInt(_))) |> (arr => arr.filter(_>0)) |> test)
    

    test(Array(1, 2, 3, 0, 5, 6))
    testRandom(5)
    testRandom(10)
    testRandom(10)
    testRandom(30)
    testRandom(100)
  }
}
