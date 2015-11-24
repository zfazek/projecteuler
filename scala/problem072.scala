import BigInt._

def f_gcd(x: Int, y: Int): Int = if(x == 0) y else f_gcd(y % x, x)

def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

def sum(x: BigInt, s: BigInt): BigInt =
  if (x == 0) s
else sum(x - 1, s + x)

def primeFactors(primes: IndexedSeq[Int], x: Int, factors: Set[Int]): Set[Int] = 
  if (x == 1) factors
else if (x % primes.head == 0) 
  primeFactors(primes, x / primes.head, factors + primes.head)
else primeFactors(primes.tail, x, factors)

def primeFactors1(k:Int, x: Int, factors: Set[Int]): Set[Int] = 
  if (x == 1) factors
else if (x % primes(k) == 0) 
  primeFactors1(k, x / primes(k), factors + primes(k))
else primeFactors1(k+1, x, factors)

def phiEuler(x: Int, xs: Set[Int]): Int = {
  def iter(xs: Set[Int], n: BigInt, d: BigInt): Tuple2[BigInt, BigInt] =
    if (xs.isEmpty) (n, d)
    else iter(xs.tail, n * (xs.head - 1), d * xs.head)
  val r = iter(xs, 1, 1)
  (x * r._1 / r._2).toInt
}

val limit = 1000000
val primes = (2 to limit) filter isPrime

def solution3() {
//  val r = for (i <- 2 to limit) yield (phiEuler(i, primeFactors(primes, i, Set())))
  val r = for (i <- 2 to limit) yield (phiEuler(i, primeFactors1(0, i, Set())))
  val r1 = r map ((x:Int) => BigInt(x))
    println(limit, r1.sum)
}

/*
def solution1() {
  var gcd = 0
  var r = (1, 1)
  val ss = scala.collection.mutable.Set[Pair[Int, Int]]()
  for (n <- 1 until limit)
  for (d <- n + 1 to limit) {
    gcd = f_gcd(n, d)
    r = (n/gcd, d/gcd)
    ss += r
  }
  //println(ss)
  println("limit: " + limit +", ss.length: " + ss.size)
}
*/

def solution2(limit: Int) {
  var minus = BigInt("0")
  val primes = (2 to limit) filter isPrime
//  println(primes.length)
  var ps3 = scala.collection.mutable.Set[Int]()
  val sums = sum(limit - 1, 0)
  for (i <- 2 until limit) {
    if (i % 100 == 0) 
      println(i)
    val ps = primeFactors(primes, i, Set())
    ps3.clear()
    for (p <-ps) {
      val ps2 = for (j <- i + p to limit by p) yield (j)
      val ps2a = ps2.toList.toSet
      ps3 = ps3 ++ ps2a
//      println(i, ps, ps1, ps1.sum, ps3.size, ps3)
    }
    minus += ps3.size
    /*
    val pss = ps filter (_ <= limit - i)
    val ps1 = pss.map(x=>(limit-i)/x)
    if (ps1.size <= 1) {
      println(i, ps, ps1.sum, ps3.size, ps3.toList.sorted)
      minus += ps1.sum
    }
    else if (ps1.size ==2) {
      val m = (limit - i)/pss.product
      println(i, ps, pss, ps1.sum - m, ps3.size, ps3.toList.sorted)
      minus += ps1.sum - m
    }
    else {
      println(i, ps, pss, ps1.sum , (pss.sum-1), ps3.size, ps3.toList.sorted)
      minus += ps1.sum - (pss.sum-1)
    }
    */
  }
  println(limit, sums, minus, sums - minus)
}

solution3()
