import utils.{TestUtils => T}
import utils.Pipeline.Pipe

object RotateArray {
  def rotate(nums: Array[Int], k: Int): Unit = 
    (nums.drop(nums.length - k%nums.length) //
        ++ 
    nums.take(nums.length - k%nums.length))
      .zipWithIndex
      .foreach { 
        case (value, index) => 
          nums(index) = value
      }
  

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int], k: Int): Unit = {
      printf("%-7s %-20s\n", "CASE:", nums.mkString(","))
      printf("%-7s %-20s\n", "K:", k)
      rotate(nums, k)
      printf("%-7s %-20s\n", "output:", nums.mkString(","))
      println()
    }
    def testRandom(length: Int = 10): Unit = 
      (length |> (T.rangeA(1,_)) |> (test(_, T.randomNumber(max=length))))
 
    
    test(T.range(1,7), 5)
    testRandom(25)
    testRandom(50)
  }
}