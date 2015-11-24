def sum(x: Int): Boolean = 
  if (x == 89) true
  else if (x == 1) false
  else sum(x.toString.map(x=>x.toInt-48).map(x=>x*x).sum)

val limit = 10000000
val res = (1 until limit) filter sum
println(res.size)
