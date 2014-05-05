def f_gcd(x: Int, y: Int): Int = {
  if(x == 0) y else f_gcd(y % x, x)
}

def min(a: Int, b: Int) = if (a < b) a else b

val limit = 1000000

var gcd = 0
var r = (1, 1, 1.0)
var ls = new scala.collection.mutable.ListBuffer[Tuple3[Int, Int, Double]]
val lower = 42857/100000.toDouble
val upper = 3/7.toDouble
for (n <- 1 until limit)
  for (d <- (n/upper).toInt to min((n/lower).toInt, limit)) 
//  for (d <- 1 to limit) 
    if (n/d.toDouble > lower && n/d.toDouble <= upper) {
      gcd = f_gcd(n, d)
      r = (n/gcd, d/gcd, n.toDouble/d)
      ls += r
    }
println("ls.length: " + ls.length)

val ls1 = ls sortBy(_._3)
//println(ls1)
val ls2 = ls1 map (x => (x._1, x._2))
val idx = ls2 indexOf ((3, 7))
if (idx > -1) {
//  println(ls2)
  val ls3 = ls2 filterNot(x=>x._1 ==3 && x._2==7)
  println(ls3.reverse.head)
}
else 
  println("not found")
