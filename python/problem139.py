#!/usr/bin/env python

import sys

limit = 10**8


'''
sq = set()
#for c in range(1,limit):
for c in range(1,7000000):
    sq.add(c*c)

r = list()

for a in xrange(1, limit):
        b = a + 1
#    for b in xrange(a, limit):
        cc = a*a+b*b
        c = int(cc**.5)
#        if a + b + c < limit and cc in sq and c % (b - a) == 0:
        if a + b + c < limit and cc in sq:
            r.append((a,b,c))
            print a, b, c

s = 0
for i in r:
    (a, b, c) = i
    d = (limit - 1) / (a + b + c)
    s += d
    print min(a, b), max(a, b), c, d

print s

sys.exit(0)
'''

def gcd(a,b):
        while a:
                a, b = b%a, a
        return b

p = []
m = 2
n = 1
a = m*m-n**n
b = 2*m*n
c = m*m + n*n
while c < limit:
    n = 1
    while n < m:
        a = m*m-n*n
        b = 2*m*n
        c = m*m + n*n
        if min(a, b) + 1 == max(a, b) and a*a + b*b == c*c and gcd(a, b) == 1:
#        if a*a + b*b == c*c and gcd(a, b) == 1 and c % abs(b - a) == 0:
#            print m, n, a, b, c
            p.append((min(a,b), max(a,b), c))
        n += 1
    m += 1

#print p
print "Number of primitive triplets: %s" % len(p)

s = 0
for i in p:
    (a, b, c) = i
    d = (limit - 1) / (a + b + c)
    s += d
    print min(a, b), max(a, b), c, d

print s
