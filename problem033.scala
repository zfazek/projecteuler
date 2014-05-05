val l = for (a <- 1 to 9;
  b <- 1 to 9;
  c <- 1 to 9;
  d <- 1 to 9
  if ((10*a+b)/(10*c+d)==a/d) && ((10*a+b) % (10*c+d)) == 0 &&
  10*a+b!=10*c+d && a!=b
) yield (10*a+b, 10*c+d)

println(l)
