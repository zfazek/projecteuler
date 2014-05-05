import scala.math._
val limit = 100;
val ls = for (a <- 1 until limit; b <- 1 until limit) yield (a, b);
val l1 = ls map(x => pow(x._1.toDouble, x._2.toDouble).toString.toList.map(_.toInt - 48).takeWhile(_>0).sum);
println(l1.max);
