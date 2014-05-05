object a extends Application {

  def power(x: Int, p: Int): Int = 
    if (p == 1) x
    else x * power(x, p - 1)

  def i(x: Int, n: Int): Int = 
  if (x == 0) 0
  else {
    power(x % 10, n) + i(x / 10, n)
  }


  override def main(args: Array[String]) {
    println((2 until 1000000).filter(x => x ==i(x, 5)).sum)
  }
}
