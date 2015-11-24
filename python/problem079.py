#!/usr/bin/python

file = open("keylog.txt").readlines()
print file
f = []
s = set()
for i in file:
    f.append(i.rstrip())
for i in f:
    s.add(i[0])
    s.add(i[1])
    s.add(i[2])
print sorted(s)
