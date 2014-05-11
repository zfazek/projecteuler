#!/usr/bin/env python

def prim(x):
    if x < 2: return False
    for i in xrange(2, int(x**0.5)+1):
#        print x, i, x % i
        if x % i == 0: return False
    return True

n = 1
x = 1
p = 0
while n < 10001:
    if prim(x):
        p = x
        n += 1
#        print x
    x += 2
print p
