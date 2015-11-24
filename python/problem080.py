#!/usr/bin/python

from decimal import *

i = 2
sq = [1, 4, 9, 16, 25, 36, 49, 64, 81]
s = 0
#for p in range(90,300):
p=102
getcontext().prec = p
for i in range(2, 100):
    if i not in sq:
            n = str(Decimal(i) ** Decimal(".5"))
#            n1 = n[n.find('.')+1:]
            n2 = n[:101]
#            s = 0
            for j in n2:
                if j == '.': continue
                s += int(j) - int('0')
            print i, n2, s
