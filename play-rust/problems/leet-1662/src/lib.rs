struct Solution;

impl Solution {
    pub fn array_strings_are_equal(word1: Vec<String>, word2: Vec<String>) -> bool {
        word1.concat() == word2.concat()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::array_strings_are_equal(
            vec![String::from("ab"), String::from("c")],
            vec![String::from("a"), String::from("bc")],
        );

        assert!(result);
    }

    #[test]
    fn case2() {
        let result = Solution::array_strings_are_equal(
            vec![String::from("a"), String::from("cb")],
            vec![String::from("a"), String::from("bc")],
        );

        assert!(!result);
    }

    #[test]
    fn case3() {
        let result = Solution::array_strings_are_equal(
            vec![String::from("abc"), String::from("d"), String::from("defg")],
            vec![String::from("abcddefg")],
        );

        assert!(result);
    }
}
