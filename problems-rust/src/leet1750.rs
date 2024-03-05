struct Solution;

impl Solution {
    pub fn minimum_length(s: String) -> i32 {
        let s = s.chars().collect::<Vec<_>>();
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut min = s.len();
        while i < j {
            if s[i] == s[j] {
                while i + 1 < j && s[i + 1] == s[i] {
                    i += 1;
                }
                while i < j - 1 && s[j - 1] == s[j] {
                    j -= 1;
                }
                if i == j - 1 {
                    return 0;
                }
                i += 1;
                j -= 1;
                min = j - i + 1;
            } else {
                break;
            }
        }
        min as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        assert_eq!(Solution::minimum_length("ac".into()), 2);
    }

    #[test]
    fn case2() {
        assert_eq!(Solution::minimum_length("cabaabac".into()), 0);
    }

    #[test]
    fn case3() {
        assert_eq!(Solution::minimum_length("aabccabba".into()), 3);
    }
}
