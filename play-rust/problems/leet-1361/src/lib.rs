use std::collections::{HashSet, LinkedList};

struct Solution;

impl Solution {
    pub fn validate_binary_tree_nodes(n: i32, left_child: Vec<i32>, right_child: Vec<i32>) -> bool {
        let mut nodes = LinkedList::<i32>::new();
        let mut root = -1;
        let mut visited = HashSet::new();
        for i in 0..n {
            visited.insert(left_child[i as usize]);
            visited.insert(right_child[i as usize]);
        }
        for i in 0..n {
            if !visited.contains(&i) {
                root = i;
                break;
            }
        }
        if root == -1 {
            return false;
        }
        visited.clear();
        nodes.push_back(root);
        while !nodes.is_empty() {
            let node = nodes.pop_front().unwrap();
            if visited.contains(&node) {
                return false;
            }
            visited.insert(node);
            let left = left_child[node as usize];
            if left != -1 {
                nodes.push_back(left);
            }
            let right = right_child[node as usize];
            if right != -1 {
                nodes.push_back(right);
            }
        }
        visited.len() == n as usize
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let left_child = vec![1, -1, 3, -1];
        let right_child = vec![2, -1, -1, -1];

        let result = Solution::validate_binary_tree_nodes(4, left_child, right_child);

        assert!(result);
    }

    #[test]
    fn case2() {
        let left_child = vec![1, -1, 3, -1];
        let right_child = vec![2, 3, -1, -1];

        let result = Solution::validate_binary_tree_nodes(4, left_child, right_child);

        assert!(!result);
    }

    #[test]
    fn case3() {
        let left_child = vec![1, 0];
        let right_child = vec![-1, -1];

        let result = Solution::validate_binary_tree_nodes(2, left_child, right_child);

        assert!(!result);
    }

    #[test]
    fn case4() {
        let left_child = vec![3, -1, 1, -1];
        let right_child = vec![-1, -1, 0, -1];

        let result = Solution::validate_binary_tree_nodes(4, left_child, right_child);

        assert!(result);
    }
}
