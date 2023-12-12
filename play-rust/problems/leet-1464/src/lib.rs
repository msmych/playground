struct Solution;

impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        nums.sort();
        (nums[nums.len() - 1] - 1) * (nums[nums.len() - 2] - 1)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![3, 4, 5, 2];

        let result = Solution::max_product(nums);

        assert_eq!(result, 12);
    }

    #[test]
    fn case2() {
        let nums = vec![1, 5, 4, 5];

        let result = Solution::max_product(nums);

        assert_eq!(result, 16);
    }

    #[test]
    fn case3() {
        let nums = vec![3, 7];

        let result = Solution::max_product(nums);

        assert_eq!(result, 12);
    }
}
