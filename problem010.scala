def isPrime(n: Int): Boolean = {
    if (n < 2) false
    else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
}

println((1 until 2000000).filter(isPrime).foldLeft(0L)(_+_))

