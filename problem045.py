#!/usr/bin/python

def intersect(a, b):
    return list(set(a) & set(b))

limit = 100000
t = map(lambda x: x*(x+1)/2, range(1,limit))
p = map(lambda x: x*(3*x-1)/2, range(1,limit))
h = map(lambda x: x*(2*x-1), range(1,limit))
r = intersect(t, p)
rr = intersect(r, h)
print (sorted(rr))
