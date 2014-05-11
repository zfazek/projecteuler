#!/usr/bin/env python

def f_gcd(x, y):
    if x == 0: 
        return y
    else: 
        return f_gcd(y % x, x)

#limit = 8

for limit in range(1,13):
    ss = set()
    s1 = set()
    for n in xrange(1, limit):
        for d in xrange(n + 1, limit + 1):
            gcd = f_gcd(n, d)
            ss.add((n/gcd, d/gcd))
            s1.add((n, d))

    print limit, len(ss), len(s1), limit * (limit-1)

s2 = sorted(s1 - ss)
for i in s2:
    print i
