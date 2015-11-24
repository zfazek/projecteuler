pr1 :: Int -> Int
pr1 n = sum [ x | x <- [1..n], x `mod` 3 == 0 || x `mod` 5 == 0]

main = do
    print (pr1 9)
    print (pr1 999)
