object a extends Application {

  def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until n / 2 + 1) forall (n % _ != 0)
  }

  def circo[A](xs: List[A]): List[List[A]] = {
    var ys = xs
    var r = for (i <- 0 until xs.length) 
      yield {
        ys = ys.tail ::: List(ys.head)
        ys
      }
    r.toList
  }

  def iter(f: Int, t: Int, i: Int): List[Int] = {
    val l = (f until t) filter (isPrime(_))
//    println("l: " + l)
//    println("Number of primes: " + l.length + ". " + f + " until " + t)
    //val l1 = l map (_.toString.toList.permutations.toList)
    val l1 = l map (x => circo(x.toString.toList))
//      println("l1: " + l1)
    val l2 = l1 map (x => x map (y => y.mkString.toInt))
//    println("l2: " + l2)
    val l3 = l2 filter (x => x forall (y => isPrime(y)))
//      println("l3: " + l3)
      l3.flatten.distinct.toList
  }

  override def main(args: Array[String]) {
    val limit = 1000
    val chunk = 1000
    val r = for (i <- 0 until chunk) yield iter(i * limit, (i + 1) * limit, i)
    println("Number of circular primes: " + r.flatten.distinct.size)
    println(r.flatten.distinct.sorted)
//    println(iter(1, 198, 1))
  }
}
