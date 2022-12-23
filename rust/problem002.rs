fn fibo(n: i32) -> i32 {
    if n <= 1 {
        return n;
    }
    return fibo(n - 1) + fibo(n - 2);
}

fn main() {
    let ans: i32 = (1..100).map(|n| fibo(n)).take_while(|n| n <= &4_000_000).filter(|n| n % 2 == 0).sum();
    println!("{}", ans);
}
