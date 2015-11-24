import BigInt._

def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

def primeFactors(primes: IndexedSeq[Int], x: Int, factors: Set[Int]): Set[Int] = 
  if (x == 1) factors
  else if (x % primes.head == 0) 
    primeFactors(primes, x / primes.head, factors + primes.head)
  else primeFactors(primes.tail, x, factors)

def phiEuler(x: Int, xs: Set[Int]): Int = {
  def iter(xs: Set[Int], n: BigInt, d: BigInt): Pair[BigInt, BigInt] =
    if (xs.isEmpty) (n, d)
    else iter(xs.tail, n * (xs.head - 1), d * xs.head)
  val r = iter(xs, 1, 1)
  (x * r._1 / r._2).toInt
}

val n = 10000000
val primes = (2 to math.pow(n.toDouble, .5).toInt*10) filter isPrime
println("Primes ready", primes.length)
val pairs = for (i <- 2 until primes.length; 
  j <- i until primes.length
      if primes(i) * primes(j) < n) 
        yield (primes(i)*primes(j), 
          phiEuler(primes(i)*primes(j), Set(primes(i),primes(j))))
println("pairs.length:",pairs.length)
val pairs1 = pairs filter(x=>x._1.toString.sorted==x._2.toString.sorted)
println("pairs filter.length:",pairs1.length)
val pairs2 = pairs1 map (x=>(x._1,x._2,x._1.toDouble/x._2))
val pairs3 = pairs2.sortBy(_._3)
println(pairs3.head)
