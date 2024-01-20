use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        let mut cache: HashMap<i32, i32> = HashMap::new();
        Self::next_step(n, &mut cache)
    }

    fn next_step(n: i32, cache: &mut HashMap<i32, i32>) -> i32 {
        match n {
            0 => 0,
            1 => 1,
            2 => 2,
            n => {
                if let Some(n) = cache.get(&n) {
                    *n
                } else {
                    let steps = Self::next_step(n - 1, cache) + Self::next_step(n - 2, cache);
                    cache.insert(n, steps);
                    steps
                }
            }
        }
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::climb_stairs(2);

        assert_eq!(2, result);
    }

    #[test]
    fn case2() {
        let result = Solution::climb_stairs(3);

        assert_eq!(3, result);
    }
}
