def sum(x: Int, xs: List[Int]): Int = {
  if (x == 0) 1
  else if (xs.isEmpty) 0
  else if (x < 0) 0
  else {
    var s = 0
    for (i <- 0 to x/xs.head)
      s += sum(x - i * xs.head, xs.tail)
    s
  }
}    

def sum1(x: Int, xs: Int): Int = {
  if (x == 0) 1
  else if (xs == 0) 0
  else if (x < 0) 0
  else {
    var s = 0
    for (i <- 0 to x/xs)
      s += sum1(x - i * xs, xs - 1)
    s
  }
}    

val ss = 100
val ls = (1 until ss).toList
//println(ss, sum(ss, ls))
println(ss, sum1(ss, ss-1))
