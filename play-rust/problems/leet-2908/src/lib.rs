struct Solution;

impl Solution {
    pub fn minimum_sum(nums: Vec<i32>) -> i32 {
        let mut min_sum: i32 = -1;
        for i in 0..nums.len() {
            for j in (i + 1)..nums.len() {
                for k in (j + 1)..nums.len() {
                    let (n1, n2, n3) = (nums[i], nums[j], nums[k]);
                    let sum = n1 + n2 + n3;
                    if n2 > n1 && n2 > n3 && (min_sum == -1 || sum < min_sum) {
                        min_sum = sum;
                    }
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
