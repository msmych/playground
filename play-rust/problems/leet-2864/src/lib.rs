struct Solution;

impl Solution {
    pub fn maximum_odd_binary_number(s: String) -> String {
        let mut ones = 0;
        for c in s.chars() {
            if c == '1' {
                ones += 1;
            }
        }
        let mut result = String::new();
        let mut i = ones;
        loop {
            if i <= 1 {
        break;
            }
            result.push('1');
            i -= 1;
        }
        i = s.len() - ones;
        loop {
            if i <= 0 {
        break;
            }
            result.push('0');
            i -= 1;
        }
        result.push('1');
        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::maximum_odd_binary_number("010".into());

        assert_eq!(result, "001".to_string());
    }

    #[test]
    fn case2() {
        let result = Solution::maximum_odd_binary_number("0101".into());

        assert_eq!(result, "1001".to_string());
    }
}
