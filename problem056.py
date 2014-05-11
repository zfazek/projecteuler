#!/usr/bin/env python

limit = 100
max = 0
for a in xrange (1,limit):
    for b in xrange (1, limit):
        n = str(a**b)
        sum = 0
        for i in n:
            if i != 'L':
                sum += int(i)
        if sum > max: max = sum
#        print a, b, n, sum, max
print max
