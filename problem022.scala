import scala.io.Source
object a extends Application {

  override def main(args: Array[String]) {
    val l = Source.fromFile("names.txt").getLines().toList.sortWith(_ < _)
    val l1 = l.map(name => 
      name.map(c => (c.toInt - 64) * (l.indexOf(name) + 1)).sum)
  println(l1.sum)
}
}
