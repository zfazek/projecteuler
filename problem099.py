#!/usr/bin/python

from math import log

def power(a, b):
     if b < 0: return Null
     if b == 0: return 1
     if a == 0: return 0
     if b % 2 == 0: return power(a*a, b/2)
     else: return a * power(a*a, b/2)


ls = open("base_exp.txt").readlines()
max_n = 0
max = 0
n = 1
for i in ls:
    ii = i.split(',')
    a = int(ii[0])
    b = int(ii[1])
    r = b * log(a)
    if r > max:
        max_n = n
        max = r
#    print n, a, b, r, max, max_n
    n += 1
print max_n
