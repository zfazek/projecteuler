#!/usr/bin/env python

ds = dict() 

def divisors(x):
    s = 0
    end = x
    i = 1
    while i <= end:
        if x % i == 0:
            s += i * i
            end = end / i
        i += 1
    if x != i - 1: s += x * x
#    ds[x] = s
    return s

limit = 10**4
modulo = 3

r = 0
i = 1
while i <= limit:
    r += divisors(i)
    i += 1

print limit, r % (10**modulo)
