fn main() {
    let n = 100;
    let a: i32 = (1..=n).map(|i| i * i).sum();
    let b: i32 = (1..=n).sum::<i32>();
    let b = b * b;
    let ans = b - a;
    println!("{}", ans);
}
