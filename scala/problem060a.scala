def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 
def isPrimeBig(n: BigInt): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n.toDouble)).toInt + 1) forall (n % _ != 0)
} 

def iter(x: String, xs: List[String]): List[String] = {
  if (xs.isEmpty) Nil
  else List(x + xs.head) ++ List(xs.head + x) ++ iter(x, xs.tail)
}

def two_primes(list: List[String]): List[String] = {
  list match {
    case Nil => Nil
    case x :: xs => iter(x, xs) ++ two_primes(xs)
  }
}

def good(xs: List[Int]): Boolean = {
  val gs = two_primes(xs map (x => x.toString));
  val rs = gs forall (x => isPrime(x.toInt));
  rs;
}

def goodBig(xs: List[Int]): Boolean = {
  val gs = two_primes(xs map (x => x.toString));
  val rs = gs forall (x => isPrimeBig(BigInt(x)));
  rs;
}

var ls5: List[List[Int]] = Nil

val primes1 = (2 to 5000) filter isPrime
val primes2 = (2 to 5000) filter isPrime
val primes3 = (2 to 10000) filter isPrime
val primes4 = (2 to 100000) filter isPrime
val primes5 = (2 to 1000000) filter isPrime

println("Start")
for (a <- primes1)
  for (b <- primes2)
    if (b > a && good(List(a, b)))
      for (c <- primes3) 
        if (c > b && good(List(a, b, c)))
          for (d <- primes4)
            if (d > c && good(List(a, b, c, d))) {
              println(a, b, c, d, ls5)
              System.exit(0)
              for (e <- primes5)
                if (d > c && goodBig(List(a, b, c, d, e))) {
                  ls5 = List(a, b, c, d, e) :: ls5
                  println(a, b, c, d, e)
                }
            }


