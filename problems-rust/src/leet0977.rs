struct Solution;

impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        let mut fpi: i32 = 0;
        for (i, num) in nums.iter().enumerate() {
            if *num >= 0 {
                fpi = i as i32;
                break;
            }
        }
        let mut squares = vec![0; nums.len()];
        let mut i = fpi - 1;
        let mut j = fpi;
        let mut k = 0;
        while i >= 0 && j < nums.len() as i32 {
            if -nums[i as usize] < nums[j as usize] {
                *squares.get_mut(k).unwrap() = nums[i as usize] * nums[i as usize];
                i -= 1;
            } else {
                *squares.get_mut(k).unwrap() = nums[j as usize] * nums[j as usize];
                j += 1;
            }
            k += 1;
        }
        while i >= 0 {
            *squares.get_mut(k).unwrap() = nums[i as usize] * nums[i as usize];
            k += 1;
            i -= 1;
        }
        while (j as usize) < nums.len() {
            *squares.get_mut(k).unwrap() = nums[j as usize] * nums[j as usize];
            k += 1;
            j += 1;
        }
        squares.sort();
        squares
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![-4, -1, 0, 3, 10];

        let result = Solution::sorted_squares(nums);

        assert_eq!(result, vec![0, 1, 9, 16, 100]);
    }

    #[test]
    fn case2() {
        let nums = vec![-7, -3, 2, 3, 11];

        let result = Solution::sorted_squares(nums);

        assert_eq!(result, vec![4, 9, 9, 49, 121]);
    }

    #[test]
    fn case3() {
        let nums = vec![-5, -3, -2, -1];

        let result = Solution::sorted_squares(nums);

        assert_eq!(result, vec![1, 4, 9, 25]);
    }
}
