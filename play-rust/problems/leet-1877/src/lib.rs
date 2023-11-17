struct Solution;

impl Solution {
    pub fn min_pair_sum(nums: Vec<i32>) -> i32 {
        let mut sorted = nums;
        sorted.sort();
        let mut max = sorted[0] + sorted[sorted.len() - 1];
        for i in 0..sorted.len() / 2 {
            let sum = sorted[i] + sorted[sorted.len() - i - 1];
            if sum > max {
                max = sum;
            }
        }
        max
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![3, 5, 2, 3];

        let result = Solution::min_pair_sum(nums);

        assert_eq!(result, 7);
    }

    #[test]
    fn case2() {
        let nums = vec![3, 5, 4, 2, 4, 6];

        let result = Solution::min_pair_sum(nums);

        assert_eq!(result, 8);
    }
}
