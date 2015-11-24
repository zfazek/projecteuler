import BigInt._

object a extends Application {


  override def main(args: Array[String]) {
    val l = for (p <- 1 until 1000;
      a <- 1 until p;
        b <- 1 until p + 1 - a;
          c <- 1 until p + 1 - a - b 
            if (a+b+c==p && a*a+b*b==c*c)) yield {println(p); p}
    val l1 = l groupBy(x=>x) mapValues(_.size)
    println(l1.toSeq.sortBy(_._2))
  }

}
