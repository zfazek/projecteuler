#!/usr/bin/env python

from fractions import Fraction as f

ls = list()
for i in range(0,101):
    if i % 3 == 0:
        ls.append(i/3*2)
    else:
        ls.append(1)

ls[1] = 2
ls1 = ls[1:]

x = f(ls1.pop())
print ls1, len(ls1)
for i in range(0, len(ls1)):
    x = ls1.pop() + 1 / x
    print x
n = x.numerator
print sum(map(int, str(n))) 


