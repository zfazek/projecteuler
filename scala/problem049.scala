def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

val limit1 = 1000
val limit2 = 10000
val primes = (limit1 until limit2) filter(isPrime)
val primesSet = primes.toSet
var i = 0
var end = 0
while (i < primes.length && end < 2) {
  var n = primes(i)
  var d = 1
  while (n + 2 * d < limit2 && end < 2) {
    if (primesSet contains (n + d))
      if (primesSet contains (n + 2 * d)) {
        val ps1 = n.toString.sorted
        val ps2 = (n+d).toString.sorted
        val ps3 = (n+2*d).toString.sorted
        if (ps1==ps2 && ps1==ps3) {
          println(n, n + d, n + 2 * d, d)
          end += 1
        }
      }
      d += 1
  }
  i += 1
}
