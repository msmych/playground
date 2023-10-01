use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        let mut occurrences = HashMap::<char, u16>::new();
        for c in s.chars() {
            *occurrences.entry(c).or_insert(0) += 1;
        }
        for c in t.chars() {
            match occurrences.get(&c) {
                None => return c,
                Some(0) => return c,
                _ => *occurrences.get_mut(&c).unwrap() -= 1,
            }
        }
        '?'
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::find_the_difference("abcd".into(), "abcde".into());

        assert_eq!(result, 'e');
    }
    
    #[test]
    fn case2() {
        let result = Solution::find_the_difference("".into(), "y".into());

        assert_eq!(result, 'y');
    }
}
