import utils.{TestUtils => T}
import utils.Pipeline.Pipe

object BestTimeToBuyAndSellStock {
  def maxProfit(prices: Array[Int]): Int = {
    def analyzePrices(curr: Int = 0, min: Int, maxProfit: Int = 0): Int =
      if (curr == prices.length)
        maxProfit
      else if (prices(curr) < min)
        analyzePrices(curr+1, prices(curr), maxProfit)
      else if (prices(curr) - min > maxProfit)
        analyzePrices(curr+1, min, prices(curr) - min)
      else
        analyzePrices(curr+1, min, maxProfit)
    
    analyzePrices(min=prices(0))
  }

  def main(args: Array[String]): Unit = {
    def test(prices: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", prices.mkString(","))
      printf("%-7s %-20s\n", "output:", maxProfit(prices))
      println()
    }
    def testRandom(length: Int): Unit = 
      (length |> (T.randomIntArray(_, 4)) |> test)
    
    test(Array(7,1,5,3,6,4))
    testRandom(20)
    testRandom(50)
  }
}