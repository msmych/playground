struct Solution;

impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        let mut distinct_sorted = nums.clone();
        distinct_sorted.sort();
        distinct_sorted.dedup();
        let n = nums.len() as i32;
        let mut min = n;
        for i in 0..distinct_sorted.len() {
            let right_target = distinct_sorted[i] + n - 1;
            let mut left = i + 1;
            let mut right = distinct_sorted.len() - 1;
            let mut r = distinct_sorted.len();
            while left <= right {
                let mid = left + (right - left) / 2;
                if distinct_sorted[mid] > right_target && distinct_sorted[mid - 1] <= right_target {
                    r = mid;
                    break;
                } else if distinct_sorted[mid] <= right_target {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            let actions = i as i32 + n - r as i32;
            if actions < min {
                min = actions;
            }
        }
        min
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![4, 2, 5, 3];

        let result = Solution::min_operations(nums);

        assert_eq!(result, 0);
    }

    #[test]
    fn case2() {
        let nums = vec![1, 2, 3, 5, 6];

        let result = Solution::min_operations(nums);

        assert_eq!(result, 1);
    }

    #[test]
    fn case3() {
        let nums = vec![1, 10, 100, 1000];

        let result = Solution::min_operations(nums);

        assert_eq!(result, 3);
    }
}
