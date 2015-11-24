def toset(x: Int) = x.toString.toSet

def digits(x: Int) = {
  val x1 = toset(x);
  val x2 = toset(2*x);
  val x3 = toset(3*x);
  val x4 = toset(4*x);
  val x5 = toset(5*x);
  val x6 = toset(6*x);
  val ls = List(x2, x3, x4, x5, x6) forall (_ == x1)
  ls
}

var n = 11
var end = false
while (! end) {
  if (digits(n)) {
    println("result: " + n, 2*n, 3*n, 4*n, 5*n, 6*n);
    end = true;
  }
  n += 1
  if (n % 1000 == 0) println(n)
}

