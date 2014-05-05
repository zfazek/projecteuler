#!/usr/bin/python

def power(a, b):
     if b < 0: return Null
     if b == 0: return 1
     if a == 0: return 0
     if b % 2 == 0: return power(a*a, b/2)
     else: return a * power(a*a, b/2)


print (power(2, 7830457)*28433+1)%10000000000

