fn is_prime(n: u64) -> bool {
    if n < 2 {
        return false;
    }
    let ans = (2..(n as f64).sqrt() as u64 + 1).all(|i| n % i != 0);
    return  ans;
}

fn main() {
    let ans: u64 = (1..2_000_000).filter(|n| is_prime(*n)).sum();
    println!("{}", ans);
}
