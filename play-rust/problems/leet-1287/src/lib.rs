use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn find_special_integer(arr: Vec<i32>) -> i32 {
        let mut freq = HashMap::new();
        for &n in arr.iter() {
            *freq.entry(n).or_insert(0) += 1;
            if *freq.get(&n).unwrap() > arr.len() / 4 {
                return n;
            }
        }
        unreachable!()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let arr = vec![1, 2, 2, 6, 6, 6, 6, 7, 10];

        let result = Solution::find_special_integer(arr);

        assert_eq!(result, 6);
    }

    #[test]
    fn case2() {
        let arr = vec![1, 1];

        let result = Solution::find_special_integer(arr);

        assert_eq!(result, 1);
    }
}
