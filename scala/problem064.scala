import scala.math._

def f_gcd(x: Int, y: Int): Int = {
  if(x == 0) y else f_gcd(y % x, x)
}

def iter(x: Int, sx: Double, n: Int, y: Int, d: Int, 
  ls: List[Tuple3[Int, Int, Int]], i: Int): Int = { 
//    println(x, sx, n, y, d, ls)
    if (d == 0) -1
    else if (i == 0) -1
    else {
      val a = (n*(sx+y)/d).toInt
      val new_n = d*n
      val new_y = a*d/n-y
      val new_d = n*n*x-(n*y-a*d)*(n*y-a*d)
      val gcd = f_gcd(new_n, new_d)
//      println(x, a, new_n / gcd, new_y, new_d / gcd)
      if (ls exists(x=>x._1==new_n/gcd&&x._2==new_y&&x._3==new_d/gcd)) ls.length
      else iter(x, sx, new_n / gcd, new_y, new_d / gcd, 
        (new_n / gcd, new_y, new_d / gcd) :: ls, i -1)
  }
}

val limit = 10000
val i = 10000

val xs = (2 to limit)  map(x => iter(x, pow(x, 0.5), 1, pow(x,.5).toInt, x-pow(x,.5).toInt*pow(x,.5).toInt, List(), i))
val xs1 = xs filter (_ != -1) filter (_ % 2 == 1)
println(xs1.length)

