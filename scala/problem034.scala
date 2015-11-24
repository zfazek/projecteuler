def fact(x: BigInt): BigInt = 
  if (x ==0 || x == 1) 1
else x * fact(x - 1)

def i(x: BigInt): BigInt = 
  if (x == 0) 0
else fact(x % 10) + i(x / 10)

println((3 to 100000) filter(x => x == i(x)) sum)



