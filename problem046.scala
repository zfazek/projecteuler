object a extends Application {
    val limit = 10000
    val range = (1 until limit)
    val primes = range filter(isPrime)
    val squares = range map (x => x * x) filter (_ < limit)
    val oddComposites = range filter(_%2==1) filter(! isPrime(_)) filter(_ != 1)

  def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until n / 2 + 1) forall (n % _ != 0)
  }

  def check(x: Int): Boolean = {
    for (p <- primes) 
      for (s <- squares) {
//        println(p, s, p + 2 * s, x)
        if (p + 2 * s == x) return true
      }
    return false
  }

  override def main(args: Array[String]) {
//    println(primes)
//    println(squares)
//    println(oddComposites)
    val good = oddComposites filter (! check(_))
    println(good)
  }
}
