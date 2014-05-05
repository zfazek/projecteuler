object a extends Application {

  override def main(args: Array[String]) {
    val n = 100
    val l = for (i <- 2 to n; j <- 2 to n) yield Math.pow(i, j)
    println(l.toList.distinct.length)
  }
}



