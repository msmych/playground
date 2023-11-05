use std::collections::HashSet;

struct Solution;

impl Solution {
    pub fn find_champion(grid: Vec<Vec<i32>>) -> i32 {
        let mut teams = (0..grid.len()).collect::<HashSet<_>>();
        for t in 0..grid.len() {
            for i in 0..grid.len() {
                let n1 = grid[i][t];
                if n1 == 0 {
                    continue;
                }
                for j in 0..grid.len() {
                    if j == i {
                        continue;
                    }
                    let n2 = grid[j][t];
                    if n2 == 0 {
                        teams.remove(&j);
                    }
                }
            }
        }
        *teams.iter().next().unwrap() as i32
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let grid = vec![vec![0, 1], vec![0, 0]];

        let result = Solution::find_champion(grid);

        assert_eq!(result, 0);
    }

    #[test]
    fn case2() {
        let grid = vec![vec![0, 0, 1], vec![1, 0, 1], vec![0, 0, 0]];

        let result = Solution::find_champion(grid);

        assert_eq!(result, 1);
    }
}
