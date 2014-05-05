object a extends Application {

  def iter(x: Int, i: Int, l: List[Int]): Int = {
//    println(x, i, l)
    if (x % i == 0) -1
    else if (l.indexOf(10 * x % i) != -1) l.length - l.reverse.indexOf(10 * x % i)
      else iter((10 * x) % i, i, 10 * x % i :: l)
    }

  override def main(args: Array[String]) {
    var maxNumber = 0
    var maxSeq = 0
    for (i <- 2 until 1000) {
      val s = iter(1 % i, i, List())
//      println(i, s)
      if (s >= maxSeq) {
        maxSeq = s
        maxNumber = i
        println("1/" + i, s)
      }
    }
  }
}
