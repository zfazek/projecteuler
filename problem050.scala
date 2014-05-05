object Problem050 extends Application {
  val limit = 10000
  val primes = (2 until limit) filter isPrime

  def isPrime(n: Int): Boolean = 
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)

  def func(x: Int) = {
    var init_i = 0
    var max = 0
    while (primes(init_i) < x) {
      var n = 0
      var i = init_i
      while (n < x) {
        n += primes(i)
        i += 1
//        println(x, i, n)
      }
      if (n == x && i - init_i > max) max = i - init_i
      init_i += 1
    }
//    if (max > 0) println(x, max)
    max
  }

  override def main(args: Array[String]) {

//    println(primes)
    println(primes.length)
    val l = primes map (x => (x, func(x)))
//    println(l)
    val l1 = l.filter(x => x._2 != 0) sortBy(_._2)
    println(l1.last)
  }
}
