fn p(n: i64, x: i64) -> bool {
    (2..x).all(|i| n % i == 0)
}

fn main() {
    let ans: i64 = (1..std::i64::MAX).filter(|n| p(*n, 20)).take(1).sum();
    println!("{}", ans);
}
