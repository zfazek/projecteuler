import scala.io.Source
object a extends Application {


  override def main(args: Array[String]) {
    val t = (1 to 1000) map (x => x*(x+1)/2)
    val tt = t.toSet
//    println(tt)
    val l = Source.fromFile("words.txt").getLines().toList
    val l1 = l.map(name => name.map(c => c.toInt - 64).sum) filter(tt contains _)
  println(l1.length)
}
}
