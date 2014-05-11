#!/usr/bin/env python

limit = 100000

def isPrime(n):
    if n < 2: return False
    else:
        i = 2
        while i < n / 2 + 1:
            if n % i == 0: return False
            i += 1
        return True

primes = list()
for i in range(2, limit):
    if isPrime(i): primes.append(i)

print "Number of primes under %s: %s" % (limit, len(primes))
