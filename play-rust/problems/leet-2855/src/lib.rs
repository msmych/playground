struct Solution;

impl Solution {
    pub fn minimum_right_shifts(nums: Vec<i32>) -> i32 {
        let mut min = nums[0];
        let mut min_index = 0;
        for i in 1..nums.len() {
            if nums[i] < min {
                min = nums[i];
                min_index = i;
            }
        }
        for i in 0..(nums.len() - 1) {
            if nums[(min_index + i) % nums.len()] >= nums[(min_index + i + 1) % nums.len()] {
                return -1;
            }
        }
        ((nums.len() - min_index as usize) % nums.len()) as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![3, 4, 5, 1, 2];

        let result = Solution::minimum_right_shifts(nums);

        assert_eq!(result, 2);
    }

    #[test]
    fn case2() {
        let nums = vec![1, 3, 5];

        let result = Solution::minimum_right_shifts(nums);

        assert_eq!(result, 0);
    }

    #[test]
    fn case3() {
        let nums = vec![2, 1, 4];

        let result = Solution::minimum_right_shifts(nums);

        assert_eq!(result, -1);
    }
}

