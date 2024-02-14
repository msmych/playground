struct Solution;

impl Solution {
    pub fn rearrange_array(nums: Vec<i32>) -> Vec<i32> {
        let mut p = Vec::with_capacity(nums.len() / 2);
        let mut n = Vec::with_capacity(nums.len() / 2);
        for num in nums.iter() {
            if *num > 0 {
                p.push(num);
            } else {
                n.push(num);
            }
        }
        let mut nums = Vec::with_capacity(nums.len());
        for i in 0..p.len() {
            nums.push(*p[i]);
            nums.push(*n[i]);
        }
        nums
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![3, 1, -2, -5, 2, -4];

        let result = Solution::rearrange_array(nums);

        assert_eq!(result, vec![3, -2, 1, -5, 2, -4]);
    }

    #[test]
    fn case2() {
        let nums = vec![-1, 1];

        let result = Solution::rearrange_array(nums);

        assert_eq!(result, vec![1, -1]);
    }
}
