fn main() {
    (1..1000).for_each(|a| {
        for b in a..1000 {
            let c = 1000 - a - b;
            if a * a + b * b == c * c {
                println!("{}", a * b * c);
            }
        }
    });
}
