def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
}

def isPrime1(n: Int): Boolean = {
  if (primes contains n) true
  else false
}

/*
* n: the number which has to be converted. eg. 56003
* ds: the list contains the digits where replacing
* x: the digit to convert to: 0 to 9
* conv(56003, List(1,2), 9) => 59903
*/
def conv(n: String, ds: List[Int], d: String): String = {
  if (ds.isEmpty) n
  else conv(n.updated(ds.head, d).mkString, ds.tail, d)
}
/*
* generates the combinations of lists where you can substitute:
* List(1, 2) => List(List(1), List(2), List(1, 2))
*/
def iter(list: List[Int]): List[List[Int]] = list match { 
  case Nil => List(Nil)
  case x :: Nil => List(x :: Nil)
  case x :: xs => (iter(x :: Nil)) ++ (iter(xs)) ++ (iter(xs) map (m => x :: m))
}

def calculate(n: Int, r1: List[List[Int]]): Int = {
  for (r <- r1) {
    val l1 = (0 to 9) map(x => conv(n.toString, r, x.toString));
    val l1a = l1 filter (_(0) != '0');
    val l2 = l1a map (_.toInt) filter isPrime1;
    //val l2 = l1 map (_.toInt) filter isPrime1;
    if (l2.length >= goal) {
      println(n, l1a, r, l2, l2.length);
      return goal;
    }
  }
  0
}

val primes = ((2 until 1000000) filter isPrime).toSet

val limit = 500000
// goal: how many primes from 0 to 9 substitution
val goal = 8
//var n = 56003
var n = 101
//var n = 100109
var result = 0

while (result == 0) {
  if (isPrime1(n)) {
    // how many digits can be replaced
    val ds = (0 until n.toString.length - 1).toList
    // the list of the combinations
    val r1 = iter(ds);
//    println(ds);
//    println(r1);
    result = calculate(n, r1)
  }
  n += 1
  if (n % 10000 == 0) println(n);
//  if (n >= limit) result = 1
}

