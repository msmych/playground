use std::cmp::min;

struct Solution;

const MOD: i32 = 1_000_000_007;

impl Solution {
    pub fn num_ways(steps: i32, arr_len: i32) -> i32 {
        if arr_len == 1 {
            return 1;
        }
        let mut dp = vec![0; arr_len as usize];
        dp[0] = 1;
        dp[1] = 1;
        for i in 1..steps {
            let mut next_steps = vec![0; arr_len as usize];
            for j in 0..=min(arr_len - 1, steps - i) as usize {
                let mut step = dp[j];
                if j > 0 {
                    step = (step + dp[j - 1]) % MOD;
                }
                if j < arr_len as usize - 1 {
                    step = (step + dp[j + 1]) % MOD;
                }
                next_steps[j] = step;
            }
            dp = next_steps;
        }
        dp[0]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::num_ways(3, 2);

        assert_eq!(result, 4);
    }

    #[test]
    fn case2() {
        let result = Solution::num_ways(2, 4);

        assert_eq!(result, 2);
    }

    #[test]
    fn case3() {
        let result = Solution::num_ways(4, 2);

        assert_eq!(result, 8);
    }

    #[test]
    fn case4() {
        let result = Solution::num_ways(3, 1);

        assert_eq!(result, 1);
    }
}
