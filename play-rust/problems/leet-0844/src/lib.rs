use std::collections::LinkedList;

struct Solution;

impl Solution {
    pub fn backspace_compare(s: String, t: String) -> bool {
        Self::spell(s) == Self::spell(t)
    }

    fn spell(s: String) -> LinkedList<char> {
        let mut stack = LinkedList::new();
        for c in s.chars() {
            if c == '#' {
                stack.pop_front();
            } else {
                stack.push_front(c);
            }
        }
        stack
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::backspace_compare("ab#c".into(), "ad#c".into());

        assert!(result)
    }

    #[test]
    fn case2() {
        let result = Solution::backspace_compare("ab##".into(), "c#d#".into());

        assert!(result)
    }

    #[test]
    fn case3() {
        let result = Solution::backspace_compare("a#c".into(), "b".into());

        assert!(!result)
    }
}
