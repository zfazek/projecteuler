#!/usr/bin/env python

import sys

limit = 1500001


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
#        if min(a, b) + 1 == max(a, b) and a*a + b*b == c*c and gcd(a, b) == 1:
        if a+b+c < limit and a*a + b*b == c*c and gcd(a, b) == 1:
#        if a*a + b*b == c*c and gcd(a, b) == 1 and c % abs(b - a) == 0:
#            print m, n, a, b, c
            p.append((min(a,b), max(a,b), c))
        n += 1
    m += 1

#print p
print "Number of primitive triplets: %s" % len(p)

p1 = set()
for i in p:
    k = 1
    while True:
        (a, b, c) = i
        w = (a + b + c) * k
        if w < limit:
            p1.add((a*k, b*k, c*k))
            k += 1
        else:
            break

#print p1
print "Number of all triplets: %s" % len(p1)

p2 = dict()
for i in p1:
    (a, b, c) = i
    w = a + b + c
    if w in p2:
        k = p2[w]
        p2[w] = k + 1
    else:
        p2[w] = 1

#print p2
print "Number of all wires: %s" % len(p2)

s = 0
for i in p2:
    if p2[i] == 1:
        s += 1
print s
