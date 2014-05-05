def isPalindrome(x: BigInt): Boolean = x.toString == x.toString.reverse

def iter(x: BigInt, n: Int): Boolean = {
  if (n == 0) false
  else if (isPalindrome(x + BigInt(x.toString.reverse))) true
  else iter(x + BigInt(x.toString.reverse), n - 1)
}

//println(iter(196, 50))


val limit = 10000
val ls = (1 until limit) filter (! iter(_, 49))
println(ls.length)
