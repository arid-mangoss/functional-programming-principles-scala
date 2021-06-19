package recfun

object RecFun extends RecFunInterface:

  def main(args: Array[String]): Unit =
    println("Pascal's Triangle")
    for row <- 0 to 10 do
      for col <- 0 to row do
        print(s"${pascal(col, row)} ")
      println()

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r){
      return 1
    }
    return pascal(c, r-1) + pascal(c-1, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    
    def innerBalance(chars: List[Char], sum: Int): Int = {
      if (chars.isEmpty || sum < 0){
        return sum
      }

      if (chars.head == '('){
        return innerBalance(chars.tail, sum+1)
      }
      else if (chars.head == ')'){
        return innerBalance(chars.tail, sum-1)
      }
      else {
        return innerBalance(chars.tail, sum)
      }
    }
    return innerBalance(chars, 0) == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0 ){
      return 1
    }
    if (coins.isEmpty || money < 0){
      return 0
    }

    // num ways = num ways after using first coin + num ways without first using first coin
    return countChange(money-coins.head, coins) + countChange(money, coins.tail)
  }
