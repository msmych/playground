use std::{collections::{HashMap}, cmp::Ordering};

struct Solution;

impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut freq = HashMap::new();
        for mat in matches.iter() {
            let w = mat[0];
            let l = mat[1];
            freq.entry(w).or_insert(0);
            *freq.entry(l).or_insert(0) += 1;
        }
        let mut losers  = Vec::with_capacity(freq.len());
        for (k, v) in freq.iter() {
            losers.push((*k, *v));
        }
        losers.sort_by_key(|(_, v)| *v);
        let mut zeroes = Vec::new();
        let mut ones = Vec::new();
        for (k, v) in losers.iter() {
            match v {
                0 => zeroes.push(*k),
                1 => ones.push(*k),
                _ => break,
            }
        }
        zeroes.sort();
        ones.sort();
        vec![zeroes, ones]
    }
}

#[derive(PartialEq, Eq, Debug)]
struct Loser(i32, i32);

impl PartialOrd for Loser {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(&other))
    }
}

impl Ord for Loser {
    fn cmp(&self, other: &Self) -> Ordering {
        self.1.cmp(&other.1)
        
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let matches = vec![
            vec![1, 3],
            vec![2, 3],
            vec![3, 6],
            vec![5, 6],
            vec![5, 7],
            vec![4, 5],
            vec![4, 8],
            vec![4, 9],
            vec![10, 4],
            vec![10, 9],
        ];

        let result = Solution::find_winners(matches);

        assert_eq!(result, vec![vec![1, 2, 10], vec![4, 5, 7, 8]]);
    }

    #[test]
    fn case2() {
        let matches = vec![vec![2, 3], vec![1, 3], vec![5, 4], vec![6, 4]];

        let result = Solution::find_winners(matches);

        assert_eq!(result, vec![vec![1, 2, 5, 6], vec![]]);
    }
}
