struct Solution;

impl Solution {
    pub fn largest_perimeter(nums: Vec<i32>) -> i64 {
        let mut nums = nums;
        nums.sort();
        let mut sums: Vec<i64> = Vec::with_capacity(nums.len());
        for i in 0..nums.len() {
            sums.insert(i, nums[i] as i64);
            if i > 0 {
                *sums.get_mut(i).unwrap() += sums[i - 1];
            }
        }
        for i in (2..nums.len()).rev() {
            if (nums[i] as i64) < sums[i - 1] {
                return (nums[i] as i64) + sums[i - 1];
            }
        }
        -1
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![5, 5, 5];

        let result = Solution::largest_perimeter(nums);

        assert_eq!(result, 15);
    }

    #[test]
    fn case2() {
        let nums = vec![1, 12, 1, 2, 5, 50, 3];

        let result = Solution::largest_perimeter(nums);

        assert_eq!(result, 12);
    }

    #[test]
    fn case3() {
        let nums = vec![5, 5, 50];

        let result = Solution::largest_perimeter(nums);

        assert_eq!(result, -1);
    }
}
