def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
}

def fill(xs: List[Int], side: Int): List[Int] = {
  val delta = side - 1;
  val head = xs.head;
  val ys = head + 4*delta :: head +3*delta :: head +2*delta :: head +1*delta :: Nil;
  ys
}

var diagonals: List[Int] = List(1);
var new_diagonals: List[Int] = Nil;
var primes = 0
var nof_diagonals = 1;
var nof_new_primes = 0;
var ratio = 0.0;
var end = false;
var side = 1;
while (end == false) {
  side += 2;
  new_diagonals = fill(diagonals, side);
  diagonals = new_diagonals ++ diagonals;
  nof_diagonals += 4;
  nof_new_primes = (new_diagonals filter isPrime).length;
  primes += nof_new_primes;
  ratio = 100 * primes / nof_diagonals.toDouble;
  println(side, diagonals.head, ratio);
  if (ratio < 10.0) end = true;
//  if (side == 9) end = true;
}
