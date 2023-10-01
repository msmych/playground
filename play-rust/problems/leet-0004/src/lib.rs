struct Solution;

impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        0.0
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::find_median_sorted_arrays(vec![1, 3], vec![2]);

        assert_eq!(result, 2.0);
    }

    #[test]
    fn case2() {
        let result = Solution::find_median_sorted_arrays(vec![1, 2], vec![3, 4]);

        assert_eq!(result, 2.5);
    }
}
