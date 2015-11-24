object a extends Application {

  def dd(x: Int): Int = {
    def iter(x: Int, d: Int, sum: Int): Int = {
      if (d == 0) sum
      else if (x % d == 0) iter(x, d - 1, sum + d)
        else iter(x, d - 1, sum)
    }
    iter(x, x - 1, 0)
  }

  def abundant(x: Int): Boolean = if (dd(x) > x) true else false

  override def main(args: Array[String]) {
    val n = 28124
    val l = (1 until n).filter(i => abundant(i)).toList
    val l1 = for(i <- l; j <- l if (i + j < n)) yield i + j
    val l2 = l1.distinct.sort(_<_)
    val l3 = (1 until n).filter(x => l2.indexOf(x) == -1)
    println(l3.sum)
  }
}
