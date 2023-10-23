use std::collections::{HashMap, HashSet, BinaryHeap};

struct Solution;

impl Solution {
    pub fn minimum_sum(nums: Vec<i32>) -> i32 {
        let mut min_prefix = Vec::new();
        let mut min_suffix = Vec::new();
        let mut minp = nums[0];
        let mut mins = nums[nums.len() - 1];
        for i in 0..nums.len() {
            if nums[i] < minp {
                minp = nums[i];
            }
            min_prefix.push(minp);
            if nums[nums.len() - i - 1] < mins {
                mins = nums[nums.len() - i - 1];
            }
            min_suffix.insert(0, mins);
        }
        let mut min_sum = -1;
        for i in 1..(nums.len() - 1) {
            let tip = nums[i];
            let left = min_prefix[i - 1];
            let right = min_suffix[i + 1];
            if tip > left && tip > right {
                let sum = left + tip + right;
                if sum < min_sum || min_sum == -1 {
                    min_sum = sum;
                }
            }
        }
        min_sum
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![8, 6, 1, 5, 3];

        let result = Solution::minimum_sum(nums);

        assert_eq!(result, 9);
    }

    #[test]
    fn case2() {
        let nums = vec![5, 4, 8, 7, 10, 2];

        let result = Solution::minimum_sum(nums);

        assert_eq!(result, 13);
    }

    #[test]
    fn case3() {
        let nums = vec![6, 5, 4, 3, 4, 5];

        let result = Solution::minimum_sum(nums);

        assert_eq!(result, -1);
    }
}
