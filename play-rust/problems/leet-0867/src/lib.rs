struct Solution;

impl Solution {
    pub fn transpose(matrix: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut transposed = Vec::with_capacity(matrix[0].len());
        for _ in 0..matrix[0].len() {
            transposed.push(Vec::with_capacity(matrix.len()));
        }
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                transposed[j].push(matrix[i][j]);
            }
        }
        transposed
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let matrix = vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];

        let result = Solution::transpose(matrix);

        assert_eq!(result, vec![vec![1, 4, 7], vec![2, 5, 8], vec![3, 6, 9]]);
    }

    #[test]
    fn case2() {
        let matrix = vec![vec![1, 2, 3], vec![4, 5, 6]];

        let result = Solution::transpose(matrix);

        assert_eq!(result, vec![vec![1, 4], vec![2, 5], vec![3, 6]]);
    }
}
