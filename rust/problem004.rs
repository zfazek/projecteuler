fn main() {
    let mut nums: Vec<i32> = Vec::new();
    let min = 100;
    let max = 1000;
    for i in min..max {
        for j in min..max {
            let s = (i * j).to_string();
            let r: String = s.chars().rev().collect();
            if s == r {
                nums.push(i * j);
            }
        }
    }
    nums.sort_by(|a, b| b.cmp(a));
    println!("{:?}", nums[0]);
}
