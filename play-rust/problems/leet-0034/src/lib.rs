struct Solution;

impl Solution {
    pub fn search_range(nums: Vec<i32>, target: i32) -> Vec<i32> {
        if nums.is_empty() {
            return vec![-1, -1];
        }
        let mut first: i32 = -1;
        let mut last: i32 = -1;
        let mut left = 1;
        let mut right = nums.len() - 1;
        while left <= right {
            let mid = left + (right - left) / 2;
            let num = nums[mid as usize];
            if num == target && nums[mid as usize - 1] < num {
                first = mid as i32;
                break;
            } else if num < target {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if first == -1 {
            if nums[0] == target {
                first = 0;
            } else {
                return vec![-1, -1];
            }
        }
        if nums.len() == 1 {
            return vec![0, 0];
        }
        left = first as usize;
        right = nums.len() - 2;
        while left <= right {
            let mid = left + (right - left) / 2;
            let num = nums[mid as usize];
            if num == target && nums[mid as usize + 1] > num {
                last = mid as i32;
                break;
            } else if num > target {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if last == -1 {
            if nums[nums.len() - 1] == target {
                last = (nums.len() - 1) as i32;
            }
        }
        vec![first, last]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![5, 7, 7, 8, 8, 10];

        let result = Solution::search_range(nums, 8);

        assert_eq!(result, vec![3, 4]);
    }

    #[test]
    fn case2() {
        let nums = vec![5, 7, 7, 8, 8, 10];

        let result = Solution::search_range(nums, 6);

        assert_eq!(result, vec![-1, -1]);
    }

    #[test]
    fn case3() {
        let nums = vec![];

        let result = Solution::search_range(nums, 0);

        assert_eq!(result, vec![-1, -1]);
    }

    #[test]
    fn case4() {
        let nums = vec![2, 2];

        let result = Solution::search_range(nums, 2);

        assert_eq!(result, vec![0, 1]);
    }

    #[test]
    fn case5() {
        let nums = vec![1];

        let result = Solution::search_range(nums, 1);

        assert_eq!(result, vec![0, 0]);
    }

    #[test]
    fn case6() {
        let nums = vec![1, 2, 3, 3, 3, 3, 4, 5, 9];

        let result = Solution::search_range(nums, 3);

        assert_eq!(result, vec![2, 5]);
    }
}
