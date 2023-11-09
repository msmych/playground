struct Solution;

const MOD: u64 = 1_000_000_007;

impl Solution {
    pub fn count_homogenous(s: String) -> i32 {
        let mut last = s.chars().nth(0).unwrap();
        let mut homo: u64 = 1;
        let mut count: u64 = 0;
        for c in s.chars().skip(1) {
            if c != last {
                count += ((homo * (homo + 1)) / 2) % MOD;
                count %= MOD;
                homo = 0;
                last = c;
            }
            homo += 1;
        }
        ((count + ((homo * (homo + 1)) / 2) % MOD) % MOD) as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::count_homogenous("abbcccaa".into());

        assert_eq!(13, result);
    }

    #[test]
    fn case2() {
        let result = Solution::count_homogenous("xy".into());

        assert_eq!(2, result);
    }

    #[test]
    fn case3() {
        let result = Solution::count_homogenous("zzzzz".into());

        assert_eq!(15, result);
    }
}
