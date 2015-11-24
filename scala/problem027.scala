object a extends Application {

  def isPrime(n: Int): Boolean = 
    if (n > 0) (2 until n) forall (n % _ != 0)
    else (2 until n by -1) forall (n % _ != 0)

    override def main(args: Array[String]) {
    val limit = 999
    var max_a = -limit -1
    var max_b = -limit -1
    var n = 0           
    var a = -limit     
    var b = -limit    
    var max = -2      
    while (a <= limit) {
//      println(a)
      b = -limit
      while (b <= limit) {
        n = 0
        while (isPrime(n * n + a * n + b)) {
//          println(a, b, n, n*n+a*n+b, isPrime(n*n+a*n+b))
          n += 1
        }
//        println(a, b, n, n*n+a*n+b, isPrime(n*n+a*n+b))
        if (n - 1 > max) {
          max = n - 1
          max_a = a
          max_b = b
          println("###", a, b, max)
        }
        b += 1
      }
      a += 1
    }               
    println(max_a, max_b, max_a * max_b, max) 
    // n * n + a * n + b

  }
}



