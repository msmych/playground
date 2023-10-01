struct Solution;

impl Solution {
    pub fn reverse_words(s: String) -> String {
        s.split_whitespace()
            .map(|w| w.chars().rev().collect())
            .collect::<Vec<String>>()
            .join(" ")
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let s = "Let's take LeetCode contest";

        let result = Solution::reverse_words(s.into());

        assert_eq!(result, "s'teL ekat edoCteeL tsetnoc");
    }

    #[test]
    fn case2() {
        let s = "God Ding";

        let result = Solution::reverse_words(s.into());

        assert_eq!(result, "doG gniD");
    }
}
