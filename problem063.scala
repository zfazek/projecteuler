val ls = (1 to 50) map {n => (n, scala.math.pow(10, (n-1)/n.toDouble))} filter (n => n._2 < 9) map (n => 9 - n._2.toInt)
println(ls.sum + 1)
