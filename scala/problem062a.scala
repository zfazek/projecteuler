import scala.math
import BigInt._

def good(x: BigInt): Boolean = {
  val bx: BigInt = x*x*x;
  println(x, bx);
  if (x > limit) {
    println("VEGE");
    true;
  }
  else {
    val ps = bx.toString.permutations.filter(_(0) != '0').filter(x => cubes contains x);
    if (ps.length >= target) {
      println(bx);
      true
    }
    else false
  }
}

val limit = 500;
val target = 3;
val cubes = (1 to limit) map (x => BigInt(x)) map (x => (x*x*x).toString);
println(cubes);
println("Start...");
//println(good(1291));

var n = 1
while (good(n) == false) {
  n += 1;
}


//lazy val cs:Stream[BigInt] = BigInt(1290) #:: Stream.from(BigInt(1291));

//val result = cs.filter(good).take(1).toList(0);
