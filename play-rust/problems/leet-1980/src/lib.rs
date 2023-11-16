use std::collections::HashSet;

struct Solution;

impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        let num_set: HashSet<u32> = nums
            .iter()
            .map(|num| u32::from_str_radix(num, 2).unwrap())
            .collect();
        let m = u32::from_str_radix(&"1".repeat(nums[0].len()), 2).unwrap() + 1;
        let mut num = (u32::from_str_radix(&nums[0], 2).unwrap() + 1) % m;
        while num_set.contains(&num) {
            num += 1;
            num %= m;
        }
        let mut s = format!("{:b}", num);
        while s.len() < nums[0].len() {
            s.insert(0, '0');
        }
        s
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec!["01".into(), "10".into()];

        let result = Solution::find_different_binary_string(nums);

        assert_eq!(result, "00");
    }

    #[test]
    fn case2() {
        let nums = vec!["00".into(), "01".into()];

        let result = Solution::find_different_binary_string(nums);

        assert_eq!(result, "11");
    }

    #[test]
    fn case3() {
        let nums = vec!["111".into(), "011".into(), "001".into()];

        let result = Solution::find_different_binary_string(nums);

        assert_eq!(result, "101");
    }
}
