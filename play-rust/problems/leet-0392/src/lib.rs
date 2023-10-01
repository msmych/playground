struct Solution;

impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        let mut t_chars = t.chars();
        for c in s.chars() {
            loop {
                match t_chars.next() {
                    None => return false,
                    Some(a) if a == c => break,
                    _ => continue
                }
            }
        }
        true
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let s = String::from("abc");
        let t = String::from("ahbgdc");

        let result = Solution::is_subsequence(s, t);

        assert!(result);
    }

    #[test]
    fn case2() {
        let s = String::from("axc");
        let t = String::from("ahbgdc");

        let result = Solution::is_subsequence(s, t);

        assert!(!result);
    }
}
