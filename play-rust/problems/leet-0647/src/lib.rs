use std::collections::HashSet;

struct Solution;

impl Solution {
    pub fn count_substrings(s: String) -> i32 {
        let mut count = 0;
        let mut odd = HashSet::new();
        let chars: Vec<_> = s.chars().collect();
        for i in 0..s.len() {
            odd.insert(i);
            count += 1;
        }
        let mut even = HashSet::new();
        for i in 0..s.len() - 1 {
            if chars[i] == chars[i + 1] {
                even.insert(i);
                count += 1;
            }
        }
        for d in 1..=(s.len() / 2) {
            let mut next_odd = HashSet::new();
            let mut next_even = HashSet::new();
            for i in odd.iter() {
                if *i < d || *i >= s.len() - d {
                    continue;
                }
                if chars[i - d] == chars[i + d] {
                    next_odd.insert(*i);
                    count += 1;
                }
            }
            for i in even.iter() {
                if *i < d || *i >= s.len() - d - 1 {
                    continue;
                }
                if chars[i - d] == chars[i + d + 1] {
                    next_even.insert(*i);
                    count += 1;
                }
            }
            odd = next_odd;
            even = next_even;
        }
        count
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::count_substrings("abc".into());

        assert_eq!(result, 3);
    }

    #[test]
    fn case2() {
        let result = Solution::count_substrings("aaa".into());

        assert_eq!(result, 6);
    }

    #[test]
    fn case3() {
        let result = Solution::count_substrings("xabax".into());

        assert_eq!(result, 7);
    }

    #[test]
    fn case4() {
        let result = Solution::count_substrings("xabay".into());

        assert_eq!(result, 6);
    }

    #[test]
    fn case5() {
        let result = Solution::count_substrings("xaba".into());

        assert_eq!(result, 5);
    }
}
