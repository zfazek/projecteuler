val limit = 10000
val l = (1 to 2 * limit) map (x => x * (3 * x - 1) / 2)
val ls = l.toSet
println("numbers are ready")

var k = 1
var end = false
var j = 0
while (j < limit && end == false) {
//  println(j, r)
  k = 1
  while (k < j && end == false) {
    val d = (j*(3*j-1)-k*(3*k-1))/2
    if (ls contains d) {
      val s = (j*(3*j-1)+k*(3*k-1))/2
      if (ls contains s) {
        println("#################", j, k, d)
        end = true
      }
    }
    k += 1
  }
  j +=1
}
