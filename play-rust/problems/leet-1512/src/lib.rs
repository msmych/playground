struct Solution;

impl Solution {
    pub fn num_identical_pairs(nums: Vec<i32>) -> i32 {
        let mut count = 0;
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                if nums[i] == nums[j] {
                    count += 1;
                }
            }
        }
        count
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![1,2,3,1,1,3];

        let result = Solution::num_identical_pairs(nums);

        assert_eq!(result, 4);
    }

    #[test]
    fn case2() {
        let nums = vec![1,1,1,1];

        let result = Solution::num_identical_pairs(nums);

        assert_eq!(result, 6);
    }

    #[test]
    fn case3() {
        let nums = vec![1,2,3];

        let result = Solution::num_identical_pairs(nums);

        assert_eq!(result, 0);
    }
}
