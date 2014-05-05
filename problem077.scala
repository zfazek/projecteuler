val limit = 1000

val primes = (1 until limit) filter isPrime

def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

def sum(x: Int, xs: Int): Int =
  if (x == 0) 1
  else if (xs == -1) 0
  else if (x < 0) 0
  else {
    var s = 0
    for (i <- 0 to x/primes(xs))
      s += sum(x - i * primes(xs), xs - 1)
    s
  }
 

val result:Stream[Int] = 2 #:: Stream.from(3)
val r = result.map(x=>(x, sum(x, primes.length-1))).filter(x=>x._2>5000).take(1)
println(r)
