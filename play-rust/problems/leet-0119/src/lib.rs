struct Solution;

impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        let mut row = vec![1];
        for _ in 1..=row_index {
            let mut next = Vec::with_capacity(row.len() + 1);
            next.push(1);
            for j in 0..(row.len() - 1) {
                next.push(row[j] + row[j + 1]);
            }
            next.push(1);
            row = next;
        }
        row
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::get_row(3);

        assert_eq!(result, vec![1, 3, 3, 1]);
    }

    #[test]
    fn case2() {
        let result = Solution::get_row(0);

        assert_eq!(result, vec![1]);
    }

    #[test]
    fn case3() {
        let result = Solution::get_row(1);

        assert_eq!(result, vec![1, 1]);
    }
}
