def isPrime(n: Int): Boolean = 
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)

def right(x: String): Boolean =
  if (! isPrime(x.toInt)) false
  else if (x.length == 1) true
  else right(x.init)

def left(x: String): Boolean =
  if (! isPrime(x.toInt)) false
  else if (x.length == 1) true
  else left(x.tail)

def good(x: Int) = 
  if (left(x.toString) && right(x.toString)) true
  else false

lazy val primes: Stream[Int] = 11 #:: Stream.from(13) filter isPrime filter good
val ls = primes.take(11)
println(ls.toList)
println(ls.length, ls.sum)
