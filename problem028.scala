object a extends Application {

  def i(x: Int): Int = 
    if (x == 0) 0
    else {
      4*(2*x+1)*(2*x+1)-12*x + i(x - 1)
    }


  override def main(args: Array[String]) {
    println(1 + i(500))
  }
}
