import scala.math._
import BigInt._

type P = Tuple2[BigInt, BigInt]

def f_gcd(x: Int, y: Int): Int = {
  if(x == 0) y else f_gcd(y % x, x)
}

def iter(x: Int, sx: Double, n: Int, y: Int, d: Int, 
  p2:P, p1:P, i: Int): Tuple3[BigInt, BigInt, BigInt] = { 
    if (d == 0) (0, x, 0)
    else if (i == 0) (0, x, 0)
    else {
      val a: Int = (n*(sx+y)/d).toInt
      val b: BigInt = a*p1._1+p2._1
      val c: BigInt = a*p1._2+p2._2
      val new_n: Int = d*n
      val new_y: Int = a*d/n-y
      val new_d: Int = n*n*x-(n*y-a*d)*(n*y-a*d)
      val gcd: Int = f_gcd(new_n, new_d)
      if (b*b - x*c*c == 1) (b, x, c)
      else iter(x, sx, new_n / gcd, new_y, new_d / gcd, p1, (b, c), i - 1)
  }
}

val i = -1
val limit = 1000
val sq = ((1 to limit) map (x => x*x)).toSet
  val ds = (2 to limit) filter(x=> !(sq contains x)) map(x=>iter(x, pow(x, 0.5), 1, 0, 1, (0,1), (1,0), i)) sortBy(_._1)
println(ds)

