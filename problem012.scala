def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

def nofDivisors(x: Int): Int = {
  def primeFactors(primes: IndexedSeq[Int], x: Int, factors: List[Int]): List[Int] = 
    if (x == 1) factors
    else if (x % primes.head == 0) 
      primeFactors(primes, x / primes.head, primes.head :: factors)
    else primeFactors(primes.tail, x, factors)

  val result = primeFactors(primes, x, List())
  val r1 = result groupBy(x=>x) mapValues(_.size)
  val r2 = r1 map (x => x._2 + 1)
  //println(x, r1, r2)
  val r3 = x match {
    case 1 => 1
    case _ => r2 reduce(_ * _)
  }
  r3
}

val target = 500

val limit = 20000
val primes = (2 to limit) filter isPrime
println("Primes ready: ", primes.length)

def good() {
lazy val numbers: Stream[Int] = 2 #:: Stream.from(3)
lazy val triangles: Stream[Int] = 1 #:: triangles.zip(numbers).map(n => n._1 + n._2)
val res2 = triangles.filter(nofDivisors(_) > target).take(1)
println(res2.toList)
}

def bad() {
var n = 2
var s = 1
var d = 0
var max = 0
while (d < target) {
  s += n
  d = nofDivisors(s)
  if (d > max) {
    println(n, s, d)
    max = d
  }
  n += 1
}
}

good() 
//bad()