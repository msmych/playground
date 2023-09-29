struct Solution;

impl Solution {
    pub fn is_monotonic(nums: Vec<i32>) -> bool {
        let mut i = 0;
        let mut is_increasing = false;
        while i < nums.len() - 1 {
            let left = nums[i];
            let right = nums[i + 1];
            if right > left {
                is_increasing = true;
                break;
            }
            if right < left {
                is_increasing = false;
                break;
            }
            i += 1;
        }
        while i < nums.len() - 1 {
            let left = nums[i];
            let right = nums[i + 1];
            if is_increasing && right < left {
                return false;
            }
            if !is_increasing && right > left {
                return false;
            }
            i += 1;
        }
        true
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::is_monotonic(vec![1, 2, 2, 3]);

        assert!(result)
    }

    #[test]
    fn case2() {
        let result = Solution::is_monotonic(vec![6, 5, 4, 4]);

        assert!(result)
    }

    #[test]
    fn case3() {
        let result = Solution::is_monotonic(vec![1, 3, 2]);

        assert!(!result)
    }

    #[test]
    fn case4() {
        let result = Solution::is_monotonic(vec![3, 3, 3, 3, 5, 2]);

        assert!(!result)
    }
}
