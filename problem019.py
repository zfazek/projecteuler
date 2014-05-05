#!/usr/bin/python

from datetime import *

n = 0
for year in range(1901, 2001):
    for month in range(1, 13):
        for day in range(1, 32):
            try:
                d = date(year, month, day).weekday()
                print "%s-%s-%s: %d" % (year, month, day, d)
                if day == 1 and d == 6: n += 1
            except: pass
print n
