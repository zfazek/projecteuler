#!/usr/bin/env python

hash = dict()

def iter(x, n):
    if x in hash:
        return hash[x] + n
    if x == 1: return n
    elif x % 2 == 0: return iter(x / 2, n + 1)
    else: return iter(3 * x + 1, n + 1)

max = 0
limit = 10**6
for i in xrange(1, limit):
    m = iter(i, 0)
    hash[i] = m
    if m > max:
        print i, m
        max = m 
