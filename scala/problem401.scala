def divisors(x: BigInt): BigInt = {
  val l = (1 to x) filter (x % _ == 0)
  val l1 = l reduceLeft ((x, y) => x + y*y)
  l1
}

val limit = 100000

lazy val n: Stream[BigInt] = 1 #:: Stream.from(2) map divisors
val ls = n take(limit) reduceLeft ((x, y) => x + y) 
println(ls)
