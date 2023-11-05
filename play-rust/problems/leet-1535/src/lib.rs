use std::collections::VecDeque;

struct Solution;

impl Solution {
    pub fn get_winner(arr: Vec<i32>, k: i32) -> i32 {
        if k as usize >= arr.len() {
            return *arr.iter().max().unwrap()
        }
        let mut deque = arr.iter().collect::<VecDeque<_>>();
        let mut count = 0;
        while count < k {
            let n1 = deque.pop_front().unwrap();
            let n2 = deque.pop_front().unwrap();
            if n1 > n2 {
                count += 1;
                deque.push_front(n1);
                deque.push_back(n2);
            } else {
                count = 1;
                deque.push_front(n2);
                deque.push_back(n1);
            }
        }
        *deque[0]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let arr = vec![2, 1, 3, 5, 4, 6, 7];

        let result = Solution::get_winner(arr, 2);

        assert_eq!(result, 5);
    }

    #[test]
    fn case2() {
        let arr = vec![3, 2, 1];

        let result = Solution::get_winner(arr, 10);

        assert_eq!(result, 3);
    }

    #[test]
    fn case3() {
        let arr = vec![1, 11, 22, 33, 44, 55, 66, 77, 88, 99];

        let result = Solution::get_winner(arr, 1000000000);

        assert_eq!(result, 99);
    }
}
