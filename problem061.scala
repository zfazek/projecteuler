val l3 = (1 to 150).map(x => x*(x+1)/2).
filter(x => x < 10000 && x > 999).map(x => x.toString).
filter(x => x(2) != '0').toList
val l4 = (1 to 150).map(x => x*x).
filter(x => x < 10000 && x > 999).map(x => x.toString).
filter(x => x(2) != '0').toList
val l5 = (1 to 150).map(x => x*(3*x-1)/2).
filter(x => x < 10000 && x > 999).map(x => x.toString).
filter(x => x(2) != '0').toList
val l6 = (1 to 150).map(x => x*(2*x-1)).
filter(x => x < 10000 && x > 999).map(x => x.toString).
filter(x => x(2) != '0').toList
val l7 = (1 to 150).map(x => x*(5*x-3)/2).
filter(x => x < 10000 && x > 999).map(x => x.toString).
filter(x => x(2) != '0').toList
val l8 = (1 to 150).map(x => x*(3*x-2)).
filter(x => x < 10000 && x > 999).map(x => x.toString).
filter(x => x(2) != '0').toList

def fun3() = {
  val rs = List(l3, l4, l5).permutations.toList
  for (ls <- rs)
    for (l1 <- ls(0))
      for (l2 <- ls(1))
        if (l1(2)==l2(0)&&l1(3)==l2(1))
          for (l3 <- ls(2))
            if (l2(2)==l3(0)&&l2(3)==l3(1)&&
                l3(2)==l1(0)&&l3(3)==l1(1)) {
                  println(l1, l2, l3)
                  println(l1.toInt+l2.toInt+l3.toInt)
                  System.exit(0)
            }
}

def fun6() = {
  val rs = List(l3, l4, l5, l6, l7, l8).permutations.toList
  for (ls <- rs)
    for (l1 <- ls(0)) {
//      println(l1)
      for (l2 <- ls(1))
        if (l1(2)==l2(0)&&l1(3)==l2(1))
          for (l3 <- ls(2))
            if (l2(2)==l3(0)&&l2(3)==l3(1))
              for (l4 <- ls(3))
                if (l3(2)==l4(0)&&l3(3)==l4(1))
                  for (l5 <- ls(4))
                    if (l4(2)==l5(0)&&l4(3)==l5(1))
                      for (l6 <- ls(5))
                        if (l5(2)==l6(0)&&l5(3)==l6(1)&&
                            l6(2)==l1(0)&&l6(3)==l1(1)) {
                              println(l1, l2, l3, l4, l5, l6)
                              println(l1.toInt+l2.toInt+l3.toInt+l4.toInt+l5.toInt+l6.toInt)
                              System.exit(0)
                        }
    }
}

/*
println(l3, l3.length)
println()
println(l4, l4.length)
println()
println(l5, l5.length)
println()
println(l6, l6.length)
println()
println(l7, l7.length)
println()
println(l8, l8.length)
println()
*/

fun6()
