def f_gcd(x: Int, y: Int): Int = if(x == 0) y else f_gcd(y % x, x)

def min(a: Int, b: Int) = if (a < b) a else b

val limit = 1000

val ls = scala.collection.mutable.Set[Pair[Int, Int]]()
val lower = 1/3.toDouble
val upper = 1/2.toDouble
for (n <- 1 until limit)
  for (d <- (n/upper).toInt to min((n/lower).toInt, limit)) 
    if (n/d.toDouble > lower && n/d.toDouble < upper) {
      val gcd = f_gcd(n, d)
      val r = (n/gcd, d/gcd)
      ls += r
    }
println("ls.size: " + ls.size)
