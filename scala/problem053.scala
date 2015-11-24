def fact(x: BigInt): BigInt = {
  if (x <= 1) 1
  else x * fact(x - 1)
}

def alatt(n: BigInt, k: BigInt): BigInt = {
  fact(n) / fact(k) / fact(n - k)
}

val ls = for (n <- 1 to 100; r <- 1 to n) yield (n, r);
val l1 = ls.filter (x => alatt(x._1, x._2) > 1000000);
//println(l1);
println(l1.length);
