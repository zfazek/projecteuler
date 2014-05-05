def fact(x: Int): Int = 
  if (x == 0) 1
  else if (x == 1) 1
  else x * fact(x - 1)

def sumOfFact(x: Int): Int =
  x.toString.toList.map(_.toInt-'0').map(facts(_)).sum

def chain(x: Int, s: Int): Int = {
  val r = sumOfFact(x)
  if (r==x) s
  else if (r==871 || r==872 || r==45361 || r==45362) s + 2
  else if (r==169 || r==1454 || r==363601) s + 3
  else chain(r, s + 1)
}

val facts = scala.collection.mutable.Map[Int, Int]()
for (i <- 0 to 9)
  facts(i) = fact(i)

val limit = 1000000
val res = (1 until limit) map(chain(_,1)) filter(_==60)
println(res.length)
