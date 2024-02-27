struct Solution;

impl Solution {
    pub fn count_prefix_suffix_pairs(words: Vec<String>) -> i32 {
        let mut count = 0;
        for i in 0..(words.len() - 1) {
            let w1 = &words[i];
            for j in i + 1..words.len() {
                let w2 = &words[j];
                if w2.starts_with(w1) && w2.ends_with(w1) {
                    count += 1;
                }
            }
        }
        count
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let words = ["a", "aba", "ababa", "aa"]
            .iter()
            .map(|s| String::from(*s))
            .collect();

        let result = Solution::count_prefix_suffix_pairs(words);

        assert_eq!(4, result);
    }

    #[test]
    fn case2() {
        let words = ["pa", "papa", "ma", "mama"]
            .iter()
            .map(|s| String::from(*s))
            .collect();

        let result = Solution::count_prefix_suffix_pairs(words);

        assert_eq!(2, result);
    }

    #[test]
    fn case3() {
        let words = ["abab", "ab"].iter().map(|s| String::from(*s)).collect();

        let result = Solution::count_prefix_suffix_pairs(words);

        assert_eq!(0, result);
    }
}
