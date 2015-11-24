#!/usr/bin/env python

def good(t):
    for x in t:
#        if x < 32 or x > 127: return False
        if not x in chars: return False
    return True

def text(t):
    retstr = ""
    i = 0
    length = len(t)
    while i < length:
        retstr += chr(t[i])
        i += 1
    return retstr

def decrypt():
    #print w
    print chars
    for a in range(97, 123):
        for b in range(97, 123):
            for c in range(97, 123):
                key = [a, b, c]
                i = 0
                length = len(w)
                length = 50
                t = []
                while i < length:
    #                print int(w[i]), key[i % 3], int(w[i]) ^ key[i % 3]
                    t.append(int(w[i]) ^ key[i % 3])
                    i += 1
                if good(t):
                    print a, b, c, text(t)

sp = [32]
az = range(ord('a'), ord('z') + 1)
AZ = range(ord('A'), ord('Z') + 1)
aZ = range(ord(' '), ord('z') + 1)

chars = list()
for i in aZ: chars.append(i)

words = open('cipher1.txt').readlines()[0]
w = words.split(',')

a = 103
b = 111
c = 100

key = [a, b, c]
i = 0
length = len(w)
s = 0
while i < length:
    s += int(w[i]) ^ key[i % 3]
    i += 1
print s

