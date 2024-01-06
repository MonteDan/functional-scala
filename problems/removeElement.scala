object RemoveElement {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    def replace(replaceIndex: Int, value: Int): Int = {
      nums(replaceIndex) = value // Replaces an element
      replaceIndex+1 // Returns shifted replaceIndex
    }

    def loopNums(curr: Int = 0, replaceIndex: Int = 0): Int = 
      if (curr >= nums.length)
        replaceIndex
      else if ( nums(curr) != `val` ) 
        loopNums(
          curr+1,
          replace(replaceIndex, nums(curr))
        ) 
      else loopNums(curr+1, replaceIndex)
    
    
    loopNums()
  }

  

  def main(args: Array[String]): Unit = {
    def test(nums: Array[Int], `val`: Int): Unit = {
      val result = removeElement(nums, `val`)
      println(result)
      println(nums.slice(0,result).mkString(","))
      println()
    }

    test( Array(3,2,2,3), 3 )
    test( Array(0,1,2,2,3,0,4,2), 2 )
  }
}