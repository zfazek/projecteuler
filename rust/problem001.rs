fn main() {
    let n: i32 = (1..10000).filter(|x| x % 3 == 0 || x % 5 == 0).sum();
    println!("{}", n);
}
