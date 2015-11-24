object e014 extends App {
  def iter(x: BigInt, n: Int): Int =
    if (hash contains(x)) hash(x) + n
  else if (x == 1) n
  else if (x % 2 == 0) iter(x / 2, n + 1)
    else iter(3 * x + 1, n + 1)

  def choose(a: Pair[Int, Int], b: Pair[Int, Int]) = 
    if (a._2 > b._2) a
  else b

  var hash = scala.collection.mutable.Map[BigInt, Int]()
    val limit = 1000000

  //val l1 = (1 until limit) map (x => (x, iter(x, 1))) sortBy(_._2)
  //println(l1.reverse.head)

  //val l2 = (1 until limit) map (x => (x, iter(x, 1))) reduceLeft{ (a, b) => choose(a, b) }
  //println(l2)

  //lazy val l3: Stream[Int] = 1 #:: (Stream.from(2) map (_ + 1))
  //println(l3.take(20).toList)


  var max = 0
  var m = 0
  for (i <- 1 until limit) {
    m = iter(i, 1)
    hash(i) = m
    if (m > max) {
      println(i, m)
      max = m
    }
  }
}
