struct Solution;

impl Solution {
    pub fn maximum_element_after_decrementing_and_rearranging(arr: Vec<i32>) -> i32 {
        let mut sorted = arr;
        sorted.sort();
        let mut max = 1;
        for i in 1..sorted.len() {
            if sorted[i] > max {
                max += 1;
            }
        }
        max
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let arr = vec![2, 2, 1, 2, 1];

        let result = Solution::maximum_element_after_decrementing_and_rearranging(arr);

        assert_eq!(result, 2);
    }

    #[test]
    fn case2() {
        let arr = vec![100, 1, 1000];

        let result = Solution::maximum_element_after_decrementing_and_rearranging(arr);

        assert_eq!(result, 3);
    }

    #[test]
    fn case3() {
        let arr = vec![1, 2, 3, 4, 5];

        let result = Solution::maximum_element_after_decrementing_and_rearranging(arr);

        assert_eq!(result, 5);
    }

    #[test]
    fn case4() {
        let arr = vec![91205];

        let result = Solution::maximum_element_after_decrementing_and_rearranging(arr);

        assert_eq!(result, 1);
    }
}
