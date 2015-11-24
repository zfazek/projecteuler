
def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
}

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
  //        if (max > 0) println(x, max)
  max
}

def f(xs: List[Int], x: Int, max: Int): Int = {
  //  println(xs, x, max)
  if (xs.isEmpty) max
  else {
    var i = 0
    var n = 0
    while (i < xs.length && n < x) {
      n += xs(i)
      i += 1
    }
    //    println(n, i)
    if (n == x && i > max) f(xs.tail, x, i)
      else f(xs.tail, x, max)
  }
}

val limit = 1000000
val primes1 = (2 until limit) filter isPrime
val primes = primes1.toList
//println(primes)
println("Number of primes under " + limit + ": " + primes.length)

//val l = for (p <- primes) yield (p, f(primes, p, 0))
//val l = primes map (x => (x, func(x)))

//val l1 = l.filter(x => x._2 != 0) sortBy(_._2)
//println(l1.last)
