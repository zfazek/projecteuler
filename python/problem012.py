import math

N = 500

def two():
    i = 1
    n = 1
    max = 0
    while True:
        d = n_divisors_two(n)
        if d > max:
            max = d
            #print(n, d, max)
        if d > N:
            print(n)
            break
        i += 1
        n += i

def n_divisors_two(n):
    #print(n)
    count = 0
    for i in range(1, int(math.sqrt(n) + 1)):
        if n % i == 0:
            count += 2
            #print!("{}, ", i)
    #print(n, count)
    #print(count)
    return count

two()
