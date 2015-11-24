import BigInt._

val limit = 9000;
val target = 5;
val cubes = (1 to limit).map(x => BigInt(x)).map(x => (x*x*x).toString).map(x=>(x, x.sorted));
val cc = cubes.map(x=>x._1.sorted).groupBy(x=>x).mapValues(_.size).filter(x=>x._2 == target).map(x=>x._1);
for (i <- cc) println(cubes.filter(x=>x._2 == i))
