use std::collections::HashSet;

struct Solution;

impl Solution {
    pub fn partition_string(s: String) -> i32 {
        let mut seen = HashSet::new();
        let mut count = 1;
        for c in s.chars() {
            if seen.contains(&c) {
                count += 1;
                seen.clear();
            }
            seen.insert(c);
        }
        count
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::partition_string("abacaba".into());

        assert_eq!(result, 4);
    }

    #[test]
    fn case2() {
        let result = Solution::partition_string("ssssss".into());

        assert_eq!(result, 6);
    }
}
