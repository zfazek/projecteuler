fn main() {
    //let mut n = 13195;
    let mut n = 600851475143;
    let mut i = 2;
    while i <= n {
        if n % i == 0 && is_prime(i) {
            println!("{}", i);
            n /= i;
        } else {
            i += 1;
        }
    }
}

fn is_prime(n: u64) -> bool {
    if n < 2 {
        return false;
    }
    let ans = (2..(n as f64).sqrt() as u64 + 1).all(|i| n % i != 0);
    return  ans;
}
