struct Solution;

impl Solution {
    pub fn is_reachable_at_time(sx: i32, sy: i32, fx: i32, fy: i32, t: i32) -> bool {
        if sx == fx && sy == fy && t == 1 {
            return false;
        }
        let dx = (fx - sx).abs();
        let dy = (fy - sy).abs();
        let (diagonal_steps, side_steps) = if dx > dy {
            (dy, dx - dy)
        } else {
            (dx, dy - dx)
        };
        diagonal_steps + side_steps <= t
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let result = Solution::is_reachable_at_time(2, 4, 7, 7, 6);

        assert!(result);
    }

    #[test]
    fn case2() {
        let result = Solution::is_reachable_at_time(3, 1, 7, 3, 3);

        assert!(!result);
    }

    #[test]
    fn case3() {
        let result = Solution::is_reachable_at_time(1, 1, 1, 3, 2);

        assert!(result);
    }

    #[test]
    fn case4() {
        let result = Solution::is_reachable_at_time(1, 2, 1, 2, 1);

        assert!(!result);
    }
}
