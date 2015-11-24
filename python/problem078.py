#!/usr/bin/python


pentagonal = lambda n : int(n * (3 * n - 1) ) >> 1 # the nth pentagonal number is given by (3n^2 - n)/2
 
def generalised_pentagonal(n): # 0, -1, 1, -2, 2
     if n < 0: return 0
     if not n & 1: return pentagonal((n >> 1) + 1)  # pentagonal(n/2 + 1) if n is even
     else: return pentagonal(-(n >> 1) - 1) # pentagonal(-(n/2 + 1)) if n is odd
 
pt = [1]
n = 1
cont = True
target = 1000000
while cont:
    r, f, i = 0, -1, 0
    while True:
        k = generalised_pentagonal(i)
        if k > n: break
        if (i & 3 < 2): f = 1 # add if i is divisible by 4 or (i - 1) is divisible by 4
        else: f = -1 # subtract otherwise
        r += f * pt[n - k]
        i += 1
    pt.append(r)
    if r % target == 0:
        cont = False
    n += 1
    
 
#print pt[1: ]  # exclude 0
print len(pt)-1, pt[-1] 


