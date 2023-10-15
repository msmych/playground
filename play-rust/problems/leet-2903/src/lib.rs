struct Solution;

impl Solution {
    pub fn find_indices(nums: Vec<i32>, index_difference: i32, value_difference: i32) -> Vec<i32> {
        for i in 0..nums.len() {
            for j in 0..i as i32 - index_difference {
                if (nums[i as usize] - nums[j as usize]).abs() >= value_difference {
                    return vec![i as i32, j as i32];
                }
            }
            for j in i as i32 + index_difference..nums.len() as i32 {
                if (nums[i as usize] - nums[j as usize]).abs() >= value_difference {
                    return vec![i as i32, j as i32];
                }
            }
        }
        vec![-1,-1]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![5,1,4,1];

        let result = Solution::find_indices(nums, 2, 4);

        assert_eq!(result, vec![0,3]);
    }

    #[test]
    fn case2() {
        let nums = vec![2,1];

        let result = Solution::find_indices(nums, 0, 0);

        assert_eq!(result, vec![0,0]);
    }

    #[test]
    fn case3() {
        let nums = vec![1,2,3];

        let result = Solution::find_indices(nums, 2, 4);

        assert_eq!(result, vec![-1,-1]);
    }
}
