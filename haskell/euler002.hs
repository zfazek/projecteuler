fib' :: (Integral a) => a -> a
fib' 1 = 1
fib' 2 = 2
fib' n = fib' (n - 1) + fib' (n - 2)

fib = 1 : 2 : zipWith (+) fib (tail fib)

even' x = x `mod` 2 == 0

limit = 4000000

main = do
--    let fsEven = filter (\x -> x `mod` 2 == 0) (takeWhile (<limit) [ fib' x | x <- [1..] ])
--    let fsEven = filter (even') (takeWhile (<limit) [ fib' x | x <- [1..] ])
--    let fsEven = filter even (takeWhile (<limit) [ fib' x | x <- [1..] ])
--    let fsEven = [ x | x <- takeWhile (<limit) [ fib' x | x <- [1..] ], x `mod` 2 == 0 ]
--    let fsEven = takeWhile (<limit) [ x | x <- fib, mod x 2 == 0 ]
    let fsEven = filter even (takeWhile (<limit) fib)
    print (fsEven)
    print (sum fsEven)
