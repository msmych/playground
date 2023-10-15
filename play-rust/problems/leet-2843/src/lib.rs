struct Solution;

impl Solution {
    pub fn count_symmetric_integers(low: i32, high: i32) -> i32 {
        let mut count = 0;
        for i in low..=high {
            let s = i.to_string();
            if s.len() % 2 == 1 {
                continue;
            }
            let mut left_sum = 0;
            let mut right_sum = 0;
            for j in 0..s.len() / 2 {
                left_sum += s.chars().nth(j).unwrap() as i32;
            }
            for j in s.len() / 2..s.len() {
                right_sum += s.chars().nth(j).unwrap() as i32;
            }
            if left_sum == right_sum {
                count += 1;
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
        let result = Solution::count_symmetric_integers(1, 100);

        assert_eq!(9, result);
    }

    #[test]
    fn case2() {
        let result = Solution::count_symmetric_integers(1200, 1230);

        assert_eq!(4, result);
    }
}
