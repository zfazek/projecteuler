#!/usr/bin/python

a = 1
b = 1
n = a + b
i = 2
while len(str(n)) < 1000:
    i += 1
    n = a + b
    a = b
    b = n
print i
