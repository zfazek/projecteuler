import BigInt._

object a extends Application {

  def convert(s: String, n: Int): Int = s.apply(n).toInt - 48

  def d(ll: String) = {
    val d1  = convert(ll, 0)
    val d2  = convert(ll, 1)
    val d3  = convert(ll, 2)
    val d4  = convert(ll, 3)
    val d5  = convert(ll, 4)
    val d6  = convert(ll, 5)
    val d7  = convert(ll, 6)
    val d8  = convert(ll, 7)
    val d9  = convert(ll, 8)
    val d10 = convert(ll, 9)
//    println(d1, d2, d3, d4, d5, d26, d7, d8, d9, d10)
//    println(100*d2+10*d3+d4)
    (100*d2+10*d3+d4) % 2 == 0 && (100*d3+10*d4+d5) % 3 == 0 && 
    (100*d4+10*d5+d6) % 5 == 0 && (100*d5+10*d6+d7) % 7 == 0 && 
    (100*d6+10*d7+d8) % 11 == 0 && (100*d7+10*d8+d9) % 13 == 0 && 
    (100*d8+10*d9+d10) % 17 == 0
  }

  override def main(args: Array[String]) {
    val r = 1234567890
//    val r = 1406357289.toString
//    println(d(r))
    val l = r.toString.toList.permutations.toList map(x => x.mkString)
    val l1 = l filter(d)
    println(l1 map(x => BigInt(x)) sum)
    }
  }

