val limit = 1000000
var d = 0

def divs1(x: Int, i: Int, sum: Int): Int = {
 val r = (math.sqrt(x)).toInt
  if (r < i) sum
  else if (r*r == x) sum + i
  else if (x % i == 0) divs1(x, i + 1, sum + i + x / i)
  else divs1(x, i + 1, sum)
}

def chain(x: Int, xs: List[Int]): Tuple2[List[Int], Int] = {
  if (x == 1) (List(), 0)
  else {
    d = dmap(x)
    if (d > limit) (List(), 0)
    else if (d == x) (List(x), 1)
    else if (xs contains d) (xs, (xs indexOf d) + 1)
    else chain(d, d :: xs)
  }
}

val dmap = scala.collection.mutable.Map[Int, Int]()
for (i <- 1 to limit)
  dmap(i) = divs1(i, 2, 1)
println(dmap.size)

val res = (2 to limit) map (x=>chain(x, List(x))) filter (x=>x._2 != 0) 
val res1 = res sortBy(x=>x._2)
println(res1.last)
println(res1.last._1.min)
