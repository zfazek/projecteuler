object a extends Application {

  override def main(args: Array[String]) {
    println((1 to 1000000) filter(x => x.toString == x.toString.reverse && x.toBinaryString == x.toBinaryString.reverse) sum)
  }
}



