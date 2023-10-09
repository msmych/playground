struct Solution;

impl Solution {
    pub fn min_processing_time(processor_time: Vec<i32>, tasks: Vec<i32>) -> i32 {
        let mut sorted_time = processor_time.clone();
        sorted_time.sort();
        sorted_time.reverse();
        let mut sorted_tasks = tasks.clone();
        sorted_tasks.sort();
        let mut max = 0;
        for i in 0..sorted_time.len() {
            let local_max = sorted_time[i] + sorted_tasks[4 * i + 3];
            if local_max > max {
                max = local_max;
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
        let processor_time = vec![8, 10];
        let tasks = vec![2, 2, 3, 1, 8, 7, 4, 5];

        let result = Solution::min_processing_time(processor_time, tasks);

        assert_eq!(result, 16);
    }

    #[test]
    fn case2() {
        let processor_time = vec![10, 20];
        let tasks = vec![2, 3, 1, 2, 5, 8, 4, 3];

        let result = Solution::min_processing_time(processor_time, tasks);

        assert_eq!(result, 23);
    }
}
