use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn count_characters(words: Vec<String>, chars: String) -> i32 {
        let mut occurrences = HashMap::new();
        for c in chars.chars() {
            *occurrences.entry(c).or_insert(0) += 1;
        }
        let mut sum = 0;
        for word in words.iter() {
            let mut current = HashMap::new();
            let mut can = true;
            for c in word.chars() {
                *current.entry(c).or_insert(0) += 1;
                if !occurrences.contains_key(&c) {
                    can = false;
                    break;
                }
                if occurrences.get(&c) < current.get(&c) {
                    can = false;
                    break;
                }
            }
            if can {
                sum += word.len();
            }
        }
        sum as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let words = vec![String::from("cat"), String::from("bt"),String::from("hat"),String::from("tree")];

        let result = Solution::count_characters(words, "atach".into());
        
        assert_eq!(result, 6);
    }

    #[test]
    fn case2() {
        let words = vec![String::from("hello"), String::from("world"),String::from("leetcode")];

        let result = Solution::count_characters(words, "welldonehoneyr".into());
        
        assert_eq!(result, 10);
    }
}
