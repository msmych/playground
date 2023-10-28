struct Solution;

const MOD: i32 = 1_000_000_007;

impl Solution {
    pub fn count_vowel_permutation(n: i32) -> i32 {
        if n == 0 {
            return 0;
        }
        let mut perms = vec![1; 5];
        for _ in 1..n {
            let a = ((perms[1] + perms[2]) % MOD + perms[4]) % MOD;
            let e = (perms[0] + perms[2]) % MOD;
            let i = (perms[1] + perms[3]) % MOD;
            let o = perms[2];
            let u = (perms[2] + perms[3]) % MOD;
            perms = vec![a, e, i, o, u];
        }
        perms.iter()
            .fold(0, |i, acc| (i + acc) % MOD)
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::count_vowel_permutation(1);

        assert_eq!(result, 5);
    }

    #[test]
    fn case2() {
        let result = Solution::count_vowel_permutation(2);

        assert_eq!(result, 10);
    }

    #[test]
    fn case3() {
        let result = Solution::count_vowel_permutation(5);

        assert_eq!(result, 68);
    }

    #[test]
    fn case4() {
        let result = Solution::count_vowel_permutation(144);

        assert_eq!(result, 18208803);
    }
}
