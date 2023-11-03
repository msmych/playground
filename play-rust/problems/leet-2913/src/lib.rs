use std::collections::HashSet;

struct Solution;

impl Solution {
    pub fn sum_counts(nums: Vec<i32>) -> i32 {
        let mut sum = 0;
        for i in 0..nums.len() {
            for j in i..nums.len() {
                let count = nums
                    .iter()
                    .skip(i)
                    .take(j - i + 1)
                    .collect::<HashSet<_>>()
                    .len();
                sum += count * count;
            }
        }
        sum as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![1, 2, 1];

        let result = Solution::sum_counts(nums);

        assert_eq!(result, 15);
    }

    #[test]
    fn case2() {
        let nums = vec![1, 1];

        let result = Solution::sum_counts(nums);

        assert_eq!(result, 3);
    }
}
