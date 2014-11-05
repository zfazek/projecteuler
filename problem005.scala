def p(x: Int, m: Int): Boolean = {
  (1 to m) forall (x % _ == 0)
}

println((1 to Int.MaxValue).view.find(p(_, 10)).get)
println((1 to Int.MaxValue).view.find(p(_, 20)).get)
