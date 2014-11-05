val p = for ( a <- (1 to 999);
              b <- (1 to 999); 
    if (a*a+b*b==(1000-a-b)*(1000-a-b)))
    yield (a*b*(1000-a-b))

println(p.toList.head)

