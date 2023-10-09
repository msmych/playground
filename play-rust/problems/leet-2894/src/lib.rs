struct Solution;

impl Solution {
    pub fn difference_of_sums(n: i32, m: i32) -> i32 {
        let mut num1 = 0;
        let mut num2 = 0;
        for i in 1..=n {
            if i % m == 0 {
                num2 += i;
            } else {
                num1 += i;
            }
        }
        num1 - num2
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::difference_of_sums(10, 3);
        
        assert_eq!(19, result);
    }

    #[test]
    fn case2() {
        let result = Solution::difference_of_sums(5, 6);
        
        assert_eq!(15, result);
    }

    #[test]
    fn case3() {
        let result = Solution::difference_of_sums(5, 1);
        
        assert_eq!(-15, result);
    }
}
