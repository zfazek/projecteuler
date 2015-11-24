val s: BigInt = 600851475143L;
//val s: BigInt = 13195

def isPrim(x: BigInt): Boolean = {
  def inner(x: BigInt, n: BigInt): Boolean =
    if (x == 1) true
    else if (n % 2 == 0) false
    else if (n % x == 0) false
    else inner(x - 1, n)
  inner(x / 2 + 1, x)
}

def iter(x: BigInt, a: BigInt): Unit = 
  if (x > a) Nil
  else if (s % x == 0 && isPrim(x)) {
    println("### " + x + " " + a)
    iter(x + 1, a / x)
  }
  else {
//    println(x)
    iter(x + 1, a)
  }

iter(2, s)
