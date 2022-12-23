from functools import reduce

nums = [ x for x in range(10000) if x % 3 == 0 or x % 5 == 0]
sum = reduce(lambda a, b: a + b,  nums)
print(sum)
