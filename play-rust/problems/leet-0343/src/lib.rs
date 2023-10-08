struct Solution;

impl Solution {
    pub fn integer_break(n: i32) -> i32 {
        if n < 4 {
            return n - 1;
        }
        let mut product = 1;
        let mut i = n;
        while i > 4 {
            product *= 3;
            i -= 3;
        }
        product * i
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::integer_break(2);

        assert_eq!(result, 1);
    }

    #[test]
    fn case2() {
        let result = Solution::integer_break(10);

        assert_eq!(result, 36);
    }
}
