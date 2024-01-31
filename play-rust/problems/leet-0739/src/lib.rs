struct Solution;

struct Temp(i32, usize);

impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        let mut warmer = Vec::new();
        let mut stack: Vec<Temp> = Vec::new();
        for i in (0..temperatures.len()).rev() {
            let t = temperatures[i];
            while !stack.is_empty() {
                if t >= stack.last().unwrap().0 {
                    stack.pop();
                } else {
                    break;
                }
            }
            let w = if stack.is_empty() {
                0
            } else {
                stack.last().unwrap().1 - i
            };
            warmer.push(w as i32);
            stack.push(Temp(t, i));
        }
        warmer.reverse();
        warmer
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let temps = vec![73,74,75,71,69,72,76,73];

        let result = Solution::daily_temperatures(temps);

        assert_eq!(result, vec![1,1,4,2,1,1,0,0]);
    }

    #[test]
    fn case2() {
        let temps = vec![30,40,50,60];

        let result = Solution::daily_temperatures(temps);

        assert_eq!(result, vec![1,1,1,0]);
    }

    #[test]
    fn case3() {
        let temps = vec![30,60,90];

        let result = Solution::daily_temperatures(temps);

        assert_eq!(result, vec![1,1,0]);
    }
}
