def factors(x: Int): Int = {
  def iter(x: Int, i: Int): List[Int] = 
    if (i == x + 1) Nil
    else if (x % i == 0) i :: iter(x / i, 2)
    else iter(x, i + 1)
  iter(x, 2).distinct.length
}


val n = 2
println(factors(6))
lazy val ls: Stream[Int] = 1 #:: Stream.from(2)
println(ls.take(10).toList)
println(ls.filter(x=>factors(x) == n).toList)

/*
var i = 2
var cont = true
while (cont) {
  i += 1
  if (factors(i) == n)
    if (factors(i+1) == n)
      if (factors(i+2) == n)
	if (factors(i+3) == n)
	  cont = false
}
println(i)
*/
