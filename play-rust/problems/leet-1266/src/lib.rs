struct Solution;

impl Solution {
    pub fn min_time_to_visit_all_points(points: Vec<Vec<i32>>) -> i32 {
        let mut x = points[0][0];
        let mut y = points[0][1];
        let mut seconds = 0;
        for i in 1..points.len() {
            while x != points[i][0] || y != points[i][1] {
                if y == points[i][1] {
                    x = if x < points[i][0] { x + 1 } else { x - 1 };
                } else if x == points[i][0] {
                    y = if y < points[i][1] { y + 1 } else { y - 1 };
                } else {
                    x = if x < points[i][0] { x + 1 } else { x - 1 };
                    y = if y < points[i][1] { y + 1 } else { y - 1 };
                }
                seconds += 1;
            }
        }
        seconds
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let points = vec![vec![1, 1], vec![3, 4], vec![-1, 0]];

        let result = Solution::min_time_to_visit_all_points(points);

        assert_eq!(result, 7);
    }

    #[test]
    fn case2() {
        let points = vec![vec![3, 2], vec![-2, 2]];

        let result = Solution::min_time_to_visit_all_points(points);

        assert_eq!(result, 5);
    }
}
