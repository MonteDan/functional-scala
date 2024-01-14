import utils.{TestUtils => T}


object GasStation {
  def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
    def testStations(start: Int, total: Int, i: Int): Int = 
      if (start == gas.length) -1
      else if (i == gas.length) start
      else if (total + gas(i) - cost(i) < 0) testStations(i+1, 0, i+1)
      else testStations(start, total + gas(i) - cost(i), i + 1)
      
    if (gas.sum < cost.sum) -1
    else testStations(0, 0, 0)
  }
  



  def main(args: Array[String]): Unit = {
    def test(gas: Array[Int], cost: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "GAS:", gas.mkString(","))
      printf("%-7s %-20s\n", "COST:", cost.mkString(","))
      val (output, runtime, memory) = T.measure {
        canCompleteCircuit(gas,cost)
      }
      printf("%-7s %-20s\n", "output:", output)
      println(s"$runtime ms, $memory KB")

      println()
    }

    def testRandom(length: Int): Unit = {
      test(
        T.generateRandomIntArray(length),
        T.generateRandomIntArray(length)
      )
    }


    test(
      Array(1,2,3,4,5),
      Array(3,4,5,1,2)
    )

    test(
      Array(2,3,4),
      Array(3,4,3)
    )

    test(
      Array(5,1,2,3,4),
      Array(4,4,1,5,1)
    )

    testRandom(20)
    testRandom(50)
  }
}