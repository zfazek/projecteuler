def iter(n:Int, xs: List[(BigInt, BigInt)], a: BigInt, b: BigInt): List[(BigInt, BigInt)] = {
  if (n == 0) xs
  else iter(n -1, (a+b+b, a+b) :: xs, a+b+b, a+b)
}

val ls = iter(1000, List(), 1, 1) filter(x => x._1.toString.length > x._2.toString.length)
println(ls.length)