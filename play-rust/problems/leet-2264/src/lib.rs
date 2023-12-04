struct Solution;

impl Solution {
    pub fn largest_good_integer(num: String) -> String {
        let mut longest = String::new();
        for i in 0..num.len() - 2 {
            let c1 = num.chars().nth(i).unwrap();
            let c2 = num.chars().nth(i + 1).unwrap();
            let c3 = num.chars().nth(i + 2).unwrap();
            if c1 == c2 && c2 == c3 {
                let mut good = String::new();
                good.push(c1);
                good.push(c2);
                good.push(c3);
                if longest.is_empty() || good > longest {
                    longest = good;
                }
            }
        }
        longest
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::largest_good_integer("6777133339".into());

        assert_eq!(result, "777");
    }

    #[test]
    fn case2() {
        let result = Solution::largest_good_integer("2300019".into());

        assert_eq!(result, "000");
    }

    #[test]
    fn case3() {
        let result = Solution::largest_good_integer("42352338".into());

        assert_eq!(result, "");
    }
}
