struct Solution;

impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        String::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::remove_duplicate_letters("bcabc".into());

        assert_eq!("abc".to_string(), result);
    }

    #[test]
    fn case2() {
        let result = Solution::remove_duplicate_letters("bcabccbacdcbc".into());

        assert_eq!("acdb".to_string(), result);
    }
}
