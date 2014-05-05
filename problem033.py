#!/usr/bin/env python

for a in range(1,10):
    for b in range(1,10):
        for c in range(1,10):
            for d in range(1,10):
                aa = a*1.0
                bb = b*1.0
                cc = c*1.0
                dd = d*1.0
                n = 10*a+b*1.0
                d = 10*c+d*1.0
                if a==c or a==d or b==c or b==d:
                    if a!=b:
                        if n/d == aa/dd:
                            print "%s/%s" % (int(n),int(d))
