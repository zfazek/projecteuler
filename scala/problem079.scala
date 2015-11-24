import scala.io.Source

def isGood(x: List[Char], d: String): Boolean = {
  val d1 = x.indexOf(d(0))
  val d2 = x.indexOf(d(1))
  val d3 = x.indexOf(d(2))
//  println(x, d, d1, d2, d3)
  d1 < d2 && d2 < d3
}

def check(x: List[Char]): Boolean = {
  ls forall(d => isGood(x, d))
}

val ls = Source.fromFile("keylog.txt").getLines().toSet
val ds = ls.mkString.toSet.toList.sorted
val ps = ds.permutations.toList
println(ds)
println(ps.length)
println(ls)
val rs = ps filter check map(x=>x.mkString)
println("Result: ", rs)
println("Number of results: ", rs.length)
