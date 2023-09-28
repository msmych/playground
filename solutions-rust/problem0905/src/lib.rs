struct Solution;

impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        let mut result = nums.clone();
        for i in 0..result.len() {
            let n = result[i];
            if n % 2 == 0 {
                continue;
            }
            for j in (i + 1)..result.len() {
                let nj = result[j];
                if nj % 2 == 0 {
                    let left = result.get_mut(i).unwrap();
                    *left = nj;
                    let right = result.get_mut(j).unwrap();
                    *right = n;
                    break;
                }
            }
        }
        result
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let nums = vec![3, 1, 2, 4];

        let result = Solution::sort_array_by_parity(nums);

        assert_eq!(result, vec![2, 4, 3, 1]);
    }

    #[test]
    fn case2() {
        let nums = vec![0];

        let result = Solution::sort_array_by_parity(nums);

        assert_eq!(result, vec![0]);
    }
}
