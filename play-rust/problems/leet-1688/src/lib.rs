struct Solution;

impl Solution {
    pub fn number_of_matches(n: i32) -> i32 {
        let mut n = n;
        let mut count = 0;
        while n > 1 {
            if n % 2 == 0 {
                count = count + n / 2;
                n = n / 2;
            } else {
                count = count + (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        } 
        count
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::number_of_matches(7);

        assert_eq!(result, 6);
    }

    #[test]
    fn case2() {
        let result = Solution::number_of_matches(14);

        assert_eq!(result, 13);
    }
}
