struct Solution;

impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        let bytes = num.as_bytes();
        for i in (0..num.len()).rev() {
            if ((bytes[i] as char) as u8) % 2 == 1 {
                return num.chars().take(i + 1).collect();
            }
        }
        String::new()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::largest_odd_number("52".into());

        assert_eq!(result, "5");
    }

    #[test]
    fn case2() {
        let result = Solution::largest_odd_number("4206".into());

        assert_eq!(result, "");
    }

    #[test]
    fn case3() {
        let result = Solution::largest_odd_number("35427".into());

        assert_eq!(result, "35427");
    }
}
