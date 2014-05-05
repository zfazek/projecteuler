def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
}

var n = 1
var x = 1
var p = 0
while (n < 10001) {
  if (isPrime(x)) {
    p = x
    n += 1
  }
  x += 2
}
println(p)
