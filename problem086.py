#!/usr/bin/env python

import sys
import time

def gcd(a,b):
    while a:
            a, b = b%a, a
    return b

def printTime(t):
    hour = t / 3600
    minute = (t - hour * 3600) / 60
    second = t - hour * 3600 - minute * 60
    print ("\t%7d (%02d hour, %02d minutes, %02d seconds)" % 
            (res, hour, minute, second))

def getResult(limit):
    SZORZO = 30
    p = []
    m = 2
    n = 1
    a = m*m-n**n
    b = 2*m*n
    c = m*m + n*n
    while c < SZORZO*limit:
        n = 1
        while n < m:
            a = m*m-n*n
            b = 2*m*n
            c = m*m + n*n
            if (a<SZORZO*limit and b<SZORZO*limit and c<SZORZO*limit 
                    and a*a + b*b == c*c and gcd(a, b) == 1):
                #print((min(a,b), max(a,b), c))
                p.append((min(a,b), max(a,b), c))
            n += 1
        m += 1

    #print p
    #print "Number of primitive triplets: %s" % len(p)

    p1 = set()
    for i in p:
        k = 1
        while True:
            (a, b, c) = i
            if c * k < SZORZO*limit:
                p1.add((a*k, b*k, c*k))
                k += 1
            else:
                break

    p2 = set()
    for i in p1:
        (a, b, c) = i
        p2.add((a * a, b * b, c * c))

    #print p1
    #print "Number of all triplets: %s" % len(p1)

    sum = 0
    for a in range(1,limit+1):
        for b in range(a, limit+1):
            for c in range(b, limit+1):
                x = (a + b) * (a + b)
                y = c * c
                if (y,x,x+y) in p2 or \
                        (x,y,x+y) in p2:
                    #print a,b,c
                    sum += 1
    return sum

step = 10
old = 0
n = old + step
r = 20000
result_map = dict()
while old != n:
    if old < n:
        increase = True
    else:
        increase = False
    print "%5d" % n,
    sys.stdout.flush()
    start = time.time()
    if n in result_map:
        res = result_map[n]
    else:
        res = getResult(n)
        result_map[n] = res
    end = time.time()
    t = int(end - start)
    printTime(t)
    if res < r:
        old = n
        if increase == False:
            step /= 2
        n += step
    else:
        old = n
        if increase:
            step /= 2
        n -= step
