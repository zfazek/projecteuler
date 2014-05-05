def fibo(x: Int): Int = 
  if (x == 0) 0
  else if (x == 1) 1
  else fibo(x -1) + fibo(x - 2)

def iter(x: Int, acc: Int): Int = {
  val f = fibo(x)
  if (f > 4000000) acc
  else if (f % 2 == 0) iter(x + 1, acc + f)
  else iter(x + 1, acc)
}

println(iter(0, 0))
  
