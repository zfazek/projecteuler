def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
}

lazy val numbers: Stream[Int] = 2 #:: Stream.from(3)
println(numbers.filter(isPrime).take(10001).toList.last)
