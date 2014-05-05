import BigInt._

object a extends Application {

  def concat(i: Int, nTop: Int) = {
    val l = for (n <- 1 to nTop) yield i * n
    l.toList map(_.toString) mkString
  }

  def p(l1: String) = {
    val ll = BigInt(l1).toString.toList
    ll.length == 9 && ll.toSet == Set('1', '2', '3', '4', '5', '6', '7', '8', '9')
  }

  def result() = {
    val r = for (i <- 2 to 99999; n <- 2 to 9) yield concat(i, n)
    r filter(p)
  }

  override def main(args: Array[String]) {
    println(result() max)
  }

}
