object a extends Application {
  override def main(args:Array[String]) = {
    println((1 until 1000).filter(x => x % 3 == 0).sum)
  }
}
