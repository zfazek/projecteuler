import Data.List

factor :: Integer -> Integer -> [Integer] -> [Integer]
factor 1 _ fs = fs
factor n f fs
    | n < f          = fs
    | n `mod` f == 0 = factor (n `div` f) f (f:fs)
    | otherwise      = factor n (f + 1) fs

largestPrime n = sort (factor n 2 [])

main = do 
    let res = largestPrime 13195
    print (res)
    print (last res)
    let res = largestPrime 600851475143
    print (res)
    print (last res)
