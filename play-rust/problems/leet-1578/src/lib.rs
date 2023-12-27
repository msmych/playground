use std::{collections::BinaryHeap};

struct Solution;

impl Solution {
    pub fn min_cost(colors: String, needed_time: Vec<i32>) -> i32 {
        let mut heap = BinaryHeap::new();
        let mut time = needed_time[0];
        let mut chars = colors.chars();
        let mut last = chars.next().unwrap();
        heap.push(needed_time[0]);
        for i in 1..colors.len() {
            let c = chars.next().unwrap();
            let t = needed_time[i];
            time += t;
            if c != last {
                time -= heap.peek().unwrap();
                heap.clear();
                last = c;
            }
            heap.push(t);
        }
        time - heap.peek().unwrap()
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let needed_time = vec![1, 2, 3, 4, 5];

        let result = Solution::min_cost("abaac".into(), needed_time);

        assert_eq!(result, 3);
    }

    #[test]
    fn case2() {
        let needed_time = vec![1, 2, 3];

        let result = Solution::min_cost("abc".into(), needed_time);

        assert_eq!(result, 0);
    }

    #[test]
    fn case3() {
        let needed_time = vec![1, 2, 3, 4, 1];

        let result = Solution::min_cost("aabaa".into(), needed_time);

        assert_eq!(result, 2);
    }
}
