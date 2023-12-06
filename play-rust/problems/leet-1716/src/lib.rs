struct Solution;

const DOLLARS_WEEKLY: i32 = 28;

impl Solution {
    pub fn total_money(n: i32) -> i32 {
        let weeks = n / 7;
        let days = n % 7;
        weeks * DOLLARS_WEEKLY + 7 * Self::natural_sum(weeks - 1) + Self::natural_sum(days) + days * weeks
    }

    fn natural_sum(n: i32) -> i32 {
        let mut sum = 0;
        for i in 1..=n {
            sum += i;
        }
        sum
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::total_money(4);

        assert_eq!(result, 10);
    }

    #[test]
    fn case2() {
        let result = Solution::total_money(10);

        assert_eq!(result, 37);
    }

    #[test]
    fn case3() {
        let result = Solution::total_money(20);

        assert_eq!(result, 96);
    }
}
