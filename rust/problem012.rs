use std::vec;

const N: usize = 500;

fn main() {
    let start = std::time::Instant::now();
    one();
    println!("time: {} sec", start.elapsed().as_secs_f32());
    let start = std::time::Instant::now();
    two();
    println!("time: {} sec", start.elapsed().as_secs_f32());
    let start = std::time::Instant::now();
    three();
    println!("time: {} sec", start.elapsed().as_secs_f32());
    let start = std::time::Instant::now();
    four();
    println!("time: {} sec", start.elapsed().as_secs_f32());
}

fn one() {
    let ans: u64 = (1..std::u64::MAX)
        .map(|n| (1..=n).sum())
        .filter(|n| n_divisors_one(*n) > N)
        .take(1)
        .sum();
    println!("{}", ans);
}

fn n_divisors_one(n: u64) -> usize {
    2 * (1..=(n as f64).sqrt() as u64).filter(|i| n % i == 0).count()
}

fn two() {
    let mut i = 1;
    let mut n = 1;
    let mut max = 0;
    loop {
        let d = n_divisors_two(n);
        if d > max {
            max = d;
            //println!("{}: {}, ({})", n, d, max);
        }
        if d > N {
            println!("{}", n);
            break;
        }
        i += 1;
        n += i;
    }
}

fn n_divisors_two(n: u64) -> usize {
    //print!("{}: ", n);
    let mut count = 0;
    for i in 1..=(n as f32).sqrt() as u64 {
        if n % i == 0 {
            count += 2;
            //print!("{}, ", i);
        }
    }
    //println!("{} = {}", n, count);
    //println!("{}", count);
    count
}

fn three() {
    let mut i = 1;
    let mut n = 1;
    loop {
        let d = n_divisors_three(n);
        if d > N {
            println!("{}", n);
            break;
        }
        i += 1;
        n += i;
    }
}

fn n_divisors_three(n: usize) -> usize {
    let primes = vec![
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
        97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
        191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
        283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
        401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
        509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619,
        631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743,
        751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
        877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997,
    ];
    let mut n1 = n;
    let mut dn = 1;
    for prime in &primes {
        if prime * prime > n {
            break;
        }
        let mut exponent = 1;
        while n1 % prime == 0 {
            exponent += 1;
            n1 /= prime;
        }
        dn *= exponent;
        if n1 == 1 {
            break;
        }
    }
    dn
}

fn four() {
    let primes = vec![
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
        97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
        191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
        283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397,
        401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
        509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619,
        631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743,
        751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
        877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997,
    ];
    let mut cnt = 0;
    let mut n = 2;
    let mut dn = 2;
    while cnt < N {
        n += 1;
        let mut n1 = n;
        if n1 % 2 == 0 {
            n1 /= 2;
        }
        let mut dn1 = 1;
        for prime in &primes {
            if prime * prime > n1 {
                dn1 *= 2;
                break;
            }
            let mut exponent = 1;
            while n1 % prime == 0 {
                exponent += 1;
                n1 /= prime;
            }
            dn1 *= exponent;
            if n1 == 1 {
                break;
            }
        }
        cnt = dn * dn1;
        dn = dn1;
    }
    println!("{}", n * (n - 1) / 2);
}
