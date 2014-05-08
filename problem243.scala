import BigInt._

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
  //println(x, xs)
  def iter(xs: Set[Int], n: Int, d: Int): Tuple2[Int, Int] = {
    //println(xs, n, d)
    if (xs.isEmpty) (n, d)
    else iter(xs.tail, n * (xs.head - 1), d * xs.head)
  }
  val r = iter(xs, 1, 1)
    (x / r._2 * r._1)
}

//val limit = 40000000
val limit = 1000000
val primes = (2 to limit) filter isPrime
println("Number of primes below ", limit, primes.size)

//val n = 1000003
//println(phiEuler(n, primeFactors(0, n, Set())))

var i = 2;
val lim = 15499.toDouble / 94744
var r = 0.toDouble
var phi = 0.toDouble
do {
  i += 1;
  phi = phiEuler(i, primeFactors(0, i, Set())).toDouble
  r = phi / (i - 1)
  if (i % 10000 == 0) println (i, r)
} while(r >= lim)
  println(i, phi, r)
