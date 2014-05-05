def dd(x: Int): Int = {
  def iter(x: Int, d: Int, sum: Int): Int = 
    if (d == 0) sum
    else if (x % d == 0) iter(x, d - 1, sum + d)
      else iter(x, d - 1, sum)
  iter(x, x - 1, 0)
}

val l = (1 until 10000).filter(i => dd(dd(i)) == i && i != dd(i))
println(l.sum, l)
