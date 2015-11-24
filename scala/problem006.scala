def a(n: Int): Int = {
  (1 to n).map(x => x * x).sum
}

def b(n: Int): Int = {
  val r = (1 to n).sum
  r * r
}

println(b(10) - a(10))
println(b(100) - a(100))
