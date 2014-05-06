import BigInt._

def f_gcd(x: Int, y: Int): Int = if(x == 0) y else f_gcd(y % x, x)

def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

def primeFactors(k:Int, x: Int, factors: Set[Int]): Set[Int] = 
  if (x == 1) factors
else if (x % primes(k) == 0) 
  primeFactors(k, x / primes(k), factors + primes(k))
else primeFactors(k+1, x, factors)

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
  val r = for (i <- 2 to limit) yield (phiEuler(i, primeFactors(0, i, Set())))
  val r1 = r map ((x:Int) => BigInt(x))
    println(limit, r1.sum)
}


solution3()
