val limit = 50000000
val limit2 = math.pow(limit, .5).toInt + 1
val limit3 = math.pow(limit, .34).toInt + 1
val limit4 = math.pow(limit, .25).toInt + 1
println(limit2, limit3, limit4)

val primes = (2 until limit) filter isPrime
println("Number of primes: "+ primes.length)
val p2 = primes filter (_ <= limit2) map (x => x * x) filter (_ < limit)
//println(p2)
println("Number of p2: "+ p2.length)
val p3 = primes filter (_ <= limit3) map (x => x * x * x) filter (_ < limit)
//println(p3)
println("Number of p3: "+ p3.length)
val p4 = primes filter (_ <= limit4) map (x => x * x * x * x) filter (_ < limit)
//println(p4)
println("Number of p4: "+ p4.length)

def isPrime(n: Int): Boolean = {
  if (n < 2) false
  else (2 until (math.sqrt(n)).toInt + 1) forall (n % _ != 0)
} 

val res = ((for (i<-p2; j<-p3; k<-p4; if i+j+k<limit) yield (i+j+k)))//.sortBy(_._4)
//println(res)
println(res.toSet.size)
