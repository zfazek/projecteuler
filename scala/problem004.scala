val p = for ( i <- (100 to 999);
              j <- (100 to 999); 
    val r = i * j if (r.toString == r.toString.reverse))
    yield r

    println(p.toList.sort(_ > _).head)


