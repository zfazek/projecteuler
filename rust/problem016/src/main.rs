use num_bigint::BigUint;

fn main() {
    let start = std::time::Instant::now();
    let n2 = "2".parse::<BigUint>().unwrap();
    let mut n = "1".parse::<BigUint>().unwrap();
    for _ in 0..1000 {
        n = n * &n2;
    }
    let foo = n.to_string();
    let ans: u32 = foo.chars().map(|c| c.to_digit(10).unwrap()).sum();
    println!("{:?}", ans);
    println!("sec: {}", start.elapsed().as_secs_f32());
}
