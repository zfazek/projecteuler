val ls = "0123456789".permutations

def sum(s: String, a: Int, b: Int, c: Int): Int = 
  s(a).toInt + s(b).toInt + s(c).toInt

def p(s: String): Boolean = {
  val s1 = sum(s, 0, 5, 6)
  val s2 = sum(s, 1, 6, 7)
  val s3 = sum(s, 2, 7, 8)
  val s4 = sum(s, 3, 8, 9)
  val s5 = sum(s, 4, 9, 5)
  if (s1==s2&&s1==s3&&s1==s4&&s1==s5) true else false
}

def p1(s: String): Boolean = 
  if (s(0) < s(1) && s(0) < s(2) && s(0) < s(3) && s(0) < s(4)) true else false

val res = ls filter p
val res0 = res filter p1 toList
val res1 = res0 map (s => List(s(0),s(5),s(6),s(1),s(6),s(7),s(2),s(7),s(8),s(3),s(8),s(9),s(4),s(9),s(5)).mkString)
val res2 = res1 map (s=> s map (x=>(x.toInt+1-'0').toString)) map (y=>y.mkString)
println(res2.sorted.reverse.head)
