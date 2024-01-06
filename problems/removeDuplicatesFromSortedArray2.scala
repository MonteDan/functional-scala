import utils.Pipeline.Pipe
import utils.{TestUtils => T}

object RemoveDuplicatesFromSortedArray2 {
  def removeDuplicates(nums: Array[Int]): Int = {
    def replace(replaceIndex: Int, value: Int): Int = {
      nums(replaceIndex) = value
      replaceIndex // Return back the replaceIndex
    }

    def loopNums(curr: Int = 2, replaceIndex: Int = 1): Int =
      if (curr >= nums.length)
        replaceIndex + 1
      else if (nums(curr) == nums(replaceIndex) && nums(curr) == nums(replaceIndex-1))
        loopNums(
          curr + 1,
          replaceIndex
        )
      else
        loopNums(
          curr + 1,
          replace(replaceIndex+1, nums(curr))
        )
    
    if (nums.length == 1) 1
    else loopNums()
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
      length |> (T.generateRandomIntArray(_,.2)) |> (_.sorted) |> test
    }

    test(Array(0,0,1,1,1,1,2,3,3))

    testRandom(10)
    testRandom(20)
    testRandom(50)
  }
}
