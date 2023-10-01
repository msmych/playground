struct Solution;

impl Solution {
    pub fn find132pattern(nums: Vec<i32>) -> bool {
        let mut mins = Vec::with_capacity(nums.len());
        mins.push(nums[0]);
        for i in 1..nums.len() {
            mins.push(if nums[i] < mins[i - 1] {
                nums[i]
            } else {
                mins[i - 1]
            })
        }
        let mut stack = Vec::new();
        for i in (0..nums.len()).rev() {
            let num = nums[i];
            while let Some(last) = stack.last() {
                if *last <= mins[i] {
                    stack.pop();
                } else if num > mins[i] && *last < num {
                    return true;
                } else {
                    break;
                }
            }
            if num > mins[i] {
                stack.push(num);
            }
        }
        false
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 4];

        let result = Solution::find132pattern(nums);

        assert!(!result);
    }

    #[test]
    fn case2() {
        let nums = vec![3, 1, 4, 2];

        let result = Solution::find132pattern(nums);

        assert!(result);
    }

    #[test]
    fn case3() {
        let nums = vec![-1, 3, 2, 0];

        let result = Solution::find132pattern(nums);

        assert!(result);
    }

    #[test]
    fn case4() {
        let nums = vec![1, 0, 1, -4, -3];

        let result = Solution::find132pattern(nums);

        assert!(!result);
    }

    #[test]
    fn case5() {
        let nums = vec![6, 12, 3, 4, 6, 11, 20];

        let result = Solution::find132pattern(nums);

        assert!(result);
    }
}
