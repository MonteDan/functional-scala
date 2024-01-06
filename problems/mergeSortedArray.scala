object MergeSortedArray {
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    def getInsertIndex(i: Int, j: Int): Int = i + j + 1

    def insert(index: Int, value: Int): Unit = {
      nums1(index) = value
    }

    def nums1_insertAndContinue(i: Int, j: Int): Unit = {
      insert(
          getInsertIndex(i, j),
          nums1(i)
      )
      loopArrays(i - 1, j)
    }

    def nums2_insertAndContinue(i: Int, j: Int): Unit = {
      insert(
        getInsertIndex(i, j),
        nums2(j)
      )
      loopArrays(i, j - 1)
    }

    def insertLarger(i: Int, j: Int): Unit =
      if (nums1(i) > nums2(j))
        nums1_insertAndContinue(i, j)
      else
        nums2_insertAndContinue(i, j)

    def loopArrays(i: Int, j: Int): Unit =
      if (i >= 0 && j >= 0)
        insertLarger(i, j)
      else if (j >= 0)
        nums2_insertAndContinue(i, j)

    loopArrays(m - 1, n - 1)
  }


  def main(args: Array[String]): Unit = {
    val nums1 = Array(1,2,3,0,0,0)
    val m = 3
    val nums2 = Array(2,5,6)
    val n = 3

    merge(nums1, m, nums2, n)
    println(nums1.mkString(", "))
  }
}