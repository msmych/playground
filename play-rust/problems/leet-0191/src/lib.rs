struct Solution;

impl Solution {
    pub fn hammingWeight(n: u32) -> i32 {
        let mut ones = 0;
        let mut i = n;
        while i != 0 {
            ones += 1;
            i &= i - 1;
        }
        ones
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::hammingWeight(11);

        assert_eq!(result, 3);
    }

    #[test]
    fn case2() {
        let result = Solution::hammingWeight(128);

        assert_eq!(result, 1);
    }
}
