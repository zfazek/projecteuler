import BigInt._
object Main extends App {
val limit = 100000
val n = 40754
val t = (1 to limit) map (x=>BigInt(x)) map(x=>x*(x+1)/2) filter(_>n)
val p = (1 to limit) map (x=>BigInt(x)) map(x=>x*(3*x-1)/2) filter(_>n)
val h = (1 to limit) map (x=>BigInt(x)) map(x=>x*(2*x-1)) filter(_>n)
val r = p intersect h intersect t
val rr = r.sorted
println(rr)
}
