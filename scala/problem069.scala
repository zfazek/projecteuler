val ls = (400000 to 600000) filter (_%30==0)

def f_gcd(x: Int, y: Int): Int = {
  if(x == 0) y else f_gcd(y % x, x)
}

def nofRelPrimes(n: Int): Int = {
  val rp = (1 until n) map ((x: Int) => f_gcd(x, n)) filter (_ == 1)
  rp.length
}

val ls1 = ls map (x=>(x, x.toDouble/nofRelPrimes(x)))
val ls2 = ls1 sortBy(_._2)
println(ls2.reverse.head)
