#!/usr/bin/python


import sys

one = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
twenty = ["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
two = ["", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
three = ["hundred", "and"]
four = ["", "onethousand"]

def chars(r):
    s = []
    d1 = r[0] #1000
    d2 = r[1] #100
    d3 = r[2] #10
    d4 = r[3] #1
    if d1 == 1: s.append(four[d1])
    if d2 > 0: 
        s.append(one[d2])
        s.append(three[0])
        if not (d3 == 0 and d4 == 0): s.append(three[1])
    if d3 == 0 : s.append(one[d4])
    elif d3 == 1: s.append(twenty[d4])
    else:
        s.append(two[d3])
        s.append(one[d4])
    return s

def length(s):
    if len(s) == 0: return 0
    else: return len(s[0]) + length(s[1:])

def digits(x):
    r = []
    r.append(x // 1000)
    x = x % 1000
    r.append(x // 100)
    x = x % 100
    r.append(x // 10)
    x = x % 10
    r.append(x)
    return r

n = 0
for i in range(1,1001):
    ss = chars(digits(i))
    nn = length(ss)
    n += nn
    print(ss, nn, n)
print(n)
