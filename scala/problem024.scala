object a extends Application {

  def fact(x: Int): Int = 
    if (x == 0) 1
    else if (x == 1) 1
    else x * fact(x - 1)

  def iter(l: List[Int], d: Int, n: Int) {
    if (d ==1) print(l(0))
     else {
       val r = fact(d - 1)
       print(l(n / r))
       val (fl, fr) = l.splitAt(n / r)
       val ll = fl ::: fr.tail
       iter(ll, d - 1, n % r)
     }
  }


  override def main(args: Array[String]) {
    val l = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9) 
    iter(l, l.length, 1000000 - 1)
  }
}
