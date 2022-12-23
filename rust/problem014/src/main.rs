use std::collections::HashMap;

fn main() {
    let start = std::time::Instant::now();
    let mut h = HashMap::new();
    let mut max = 0;
    let mut ans = 0;
    for i in 2..1000000 {
        let n = foo(i, &h);
        h.insert(i, n);
        //println!("i: {}, n: {}", i, n);
        if n > max {
            max = n;
            ans = i;
            println!("{} {}", i, max);
        }
    }
    println!("{}", ans);
    println!("{}", start.elapsed().as_secs_f32());
}

fn foo(x: u64, h: &HashMap<u64, i32>) -> i32 {
    let mut n = 0;
    let mut x = x;
    while x > 1 {
        if h.contains_key(&x) {
            //println!("i: {}, n: {}, hash: {}", x, n, h[&x]);
            return h[&x] + n;
        }
        if x % 2 == 0 {
            x /= 2;
        } else {
            x = 3 * x + 1;
        }
        n += 1;
    }
    return  n;
}
