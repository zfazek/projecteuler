#!/usr/bin/env python

import sys

def sum(x, xs):
    if x==0: return 1
    elif len(xs)==0: return 0
    elif x<0: return 0
    else:
        s = 0
        for i in range(0,x/xs[-1]+1):
            last = xs[-1]
            xs.pop(-1)
            s += sum(x-i*last, xs)
            xs.append(last)
        return s

ss = int(sys.argv[1])
ls = list()
for i in range(1,ss):
    ls.append(i)
print ss, sum(ss, ls)

