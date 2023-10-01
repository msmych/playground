use std::fmt::Write;

struct Solution;

impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        println!("{}, {}", s, k);
        if k == 1 {
            return s.chars().nth(0).unwrap().to_string();
        }
        let mut next = String::new();
        let mut n = 0;
        for i in 0..s.len() {
            let c = s.chars().nth(i).unwrap();
            match c {
                '2'..='9' => {
                    let len = n;
                    for j in 1..c.to_digit(10).unwrap() {
                        if n + len >= k {
                            if j > 1 {
                                next.push_str(&j.to_string());
                            }
                            return Solution::decode_at_index(next, k - n);
                        }
                        n += len;
                    }
                    next.push(c);
                },
                _ => {
                    next.push(c);
                    n += 1;
                    if n == k {
                        return c.to_string();
                    }
                },
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
        let result = Solution::decode_at_index("leet2code3".into(), 10);

        assert_eq!(result, "o");
    }

    #[test]
    fn case2() {
        let result = Solution::decode_at_index("ha22".into(), 5);

        assert_eq!(result, "h");
    }

    #[test]
    fn case3() {
        let result = Solution::decode_at_index("a2345678999999999999999".into(), 1);

        assert_eq!(result, "a");
    }

    #[test]
    fn case4() {
        let result = Solution::decode_at_index("a23".into(), 6);

        assert_eq!(result, "a");
    }

    #[test]
    fn case5() {
        let result = Solution::decode_at_index("a2b3c4d5e6f7g8h9".into(), 623529);

        assert_eq!(result, "h");
    }

    #[test]
    fn case6() {
        let result = Solution::decode_at_index("cpmxv8ewnfk3xxcilcmm68d2ygc88daomywc3imncfjgtwj8nrxjtwhiem5nzqnicxzo248g52y72v3yujqpvqcssrofd99lkovg".into(), 480551547);

        assert_eq!(result, "x");
    }
}
