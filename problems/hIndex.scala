import utils.Pipeline.Pipe
import utils.{TestUtils => T}

object HIndex {
  def quickSortArray(arr: Array[Int]): Array[Int] = 
    if (arr.length < 2)
      arr
    else {
      val pivot = arr(arr.length / 2)
      Array.concat(
        quickSortArray(arr filter pivot.>),
        arr filter pivot.==,
        quickSortArray(arr filter pivot.<)
      )
    }
  
  def hIndexForSorted(citations: Array[Int]): Int = {
    def loopCitations(index: Int = 0 ): Int = 
      if (citations(index) >= citations.length - index)
        citations.length - index
      else loopCitations(index + 1)
    
    loopCitations()
  }
  

  def hIndex(citations: Array[Int]): Int = {
    // ↓ Functional solution with time complexity O(n log(n)) and O(n) space complexity
    // (citations |> quickSortArray |> hIndexForSorted)
    
    // ↓ Somewhat functional solution with O(n) time and space complexity ↓
    val storage = Array.fill(citations.length+1)(0)
    
    def getFirstValid(index: Int = citations.length, acc: Int = 0): Int =
      if (storage(index)+acc >= index) index
      else getFirstValid(index-1, acc+storage(index))

    def loopCitations(index: Int = 0): Int = {
      if (index >= citations.length) return getFirstValid()
      else {
        storage(math.min(citations(index), citations.length)) += 1
        return loopCitations(index + 1)
      }
    }

    loopCitations()
  }
    
  

  def main(args: Array[String]): Unit = {

    def test(citations: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", citations.mkString(","))
      printf("%-7s %-20s\n", "output:", hIndex(citations))
      println()
    }
    def testRandom(length: Int): Unit = 
      (length |> (T.randomIntArray(_)) |> test)

    test(Array(3,0,6,1,5))
    testRandom(15)
    testRandom(25)
    testRandom(50)
  }
}