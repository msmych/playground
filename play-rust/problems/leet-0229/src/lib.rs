use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> Vec<i32> {
        let occurrences = nums
            .iter()
            .fold(HashMap::<i32, i32>::new(), |mut acc, &num| {
                *acc.entry(num).or_insert(0) += 1;
                acc
            });
        occurrences
            .iter()
            .filter(|(_, &c)| c as usize > nums.len() / 3)
            .map(|(&num, _)| num)
            .collect()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![3, 2, 3];

        let result = Solution::majority_element(nums);

        assert_eq!(result, vec![3]);
    }

    #[test]
    fn case2() {
        let nums = vec![1];

        let result = Solution::majority_element(nums);

        assert_eq!(result, vec![1]);
    }

    #[test]
    fn case3() {
        let nums = vec![1, 2];

        let result = Solution::majority_element(nums);

        assert_eq!(result, vec![1, 2]);
    }
}
