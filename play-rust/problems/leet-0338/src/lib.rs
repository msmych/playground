struct Solution;

impl Solution {
    pub fn count_bits(n: i32) -> Vec<i32> {
        let mut i = 1;
        let mut j = 0;
        let mut base = 1;
        let mut result = Vec::with_capacity(n as usize + 1);
        result.push(0);
        while i <= n {
            if j == base {
                j = 0;
                base *= 2;
            }
            result.push(result[j] + 1);
            i += 1;
            j += 1;
        }
        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::count_bits(2);

        assert_eq!(result, vec![0, 1, 1]);
    }

    #[test]
    fn case2() {
        let result = Solution::count_bits(5);

        assert_eq!(result, vec![0, 1, 1, 2, 1, 2]);
    }
}
