import utils.{TestUtils => T}
import utils.Pipeline.Pipe

object BestTimeToBuyAndSellStock2 {
  def maxProfit(prices: Array[Int]): Int = {
    def analyzePrices(curr: Int, currProfit: Int): Int =
      if (curr == prices.length)
        currProfit
      else if (prices(curr) > prices(curr - 1))
        analyzePrices(curr + 1, currProfit + prices(curr) - prices(curr - 1))
      else
        analyzePrices(curr + 1, currProfit)

    analyzePrices(1, 0)
  }

  def main(args: Array[String]): Unit = {
    def test(prices: Array[Int]): Unit = {
      printf("%-7s %-20s\n", "CASE:", prices.mkString(","))
      printf("%-7s %-20s\n", "output:", maxProfit(prices))
      println()
    }
    def testRandom(length: Int): Unit =
      (length |> (T.randomIntArray(_, 4)) |> test)

    test(Array(7, 1, 5, 3, 6, 4))
    testRandom(20)
    testRandom(50)
  }
}
