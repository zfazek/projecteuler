object a extends Application {

  override def main(args: Array[String]) {
    def cur(l: List[Int], s: Int): Int = {
      if (s == 0) 1
      else if (l.isEmpty) 0
      else if (s < 0) 0
      else {
        val r = for (i <- 0 to s) yield cur(l.tail, s - i * l.head)
        r.sum
      }
    }
    println(cur(List(1, 2, 5, 10, 20, 50, 100, 200), 200))
  }
}



