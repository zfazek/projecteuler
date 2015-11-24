def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

val r = 1234567
val l = r.toString.permutations
val l1 = l filter((x: String) => isPrime(x.toInt))
println(l1.toList.sorted.reverse.head)

