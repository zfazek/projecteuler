import BigInt._

val limit = 99
val ls = (1 to limit) map (x => if (x == 1) 2 else if (x % 3 == 0) x * 2 / 3 else 1)

def iter(ls: List[Int], x: Pair[BigInt, BigInt]): Pair[BigInt, BigInt] = 
  if (ls.isEmpty) x
  else iter(ls.tail, (x._1 * ls.head + x._2, x._1))

val it = iter(ls.toList.reverse, (1,1))
val result = it._1.toString.map(_.toInt - '0')

println(ls)
println(it)
println(result.sum)
