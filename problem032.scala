val target = "123456789"
val limit = 2000
val l = for (i <- 0 to limit; j <- i to limit) 
  yield (i*j, (i.toString + j.toString + (i*j).toString).sorted)
val l1 = l filter(x => x._2 == target) 
val l2 = l1 map (x => x._1)
println(l2.toSet.sum)
