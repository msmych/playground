use std::collections::HashMap;

struct Solution;

impl Solution {
    pub fn find_relative_ranks(score: Vec<i32>) -> Vec<String> {
        let mut sorted = score.clone();
        sorted.sort();
        let mut map = HashMap::new();
        for i in (0..sorted.len()).rev() {
            let rank = match sorted.len() - i {
                1 => "Gold Medal".into(),
                2 => "Silver Medal".into(),
                3 => "Bronze Medal".into(),
                r => r.to_string(),
            };
            map.insert(sorted[i], rank);
        }
        let mut ranks: Vec<String> = Vec::with_capacity(score.len());
        for s in score.iter() {
            ranks.push(map.get(s).unwrap().to_owned());
        }
        ranks
    }
}

#[cfg(test)]
mod test {
    use super::*;

    #[test]
    fn case1() {
        let score = vec![5, 4, 3, 2, 1];
        let expected = vec!["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"];
        assert_eq!(Solution::find_relative_ranks(score), expected);
    }

    #[test]
    fn case2() {
        let score = vec![10, 3, 8, 9, 4];
        let expected = vec!["Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"];
        assert_eq!(Solution::find_relative_ranks(score), expected);
    }
}
