use rand::Rng;
use std::{collections::HashMap, ops::RangeBounds};

struct RandomizedSet {
    map: HashMap<i32, i32>,
    keys: Vec<i32>,
}

impl RandomizedSet {
    fn new() -> Self {
        RandomizedSet {
            map: HashMap::new(),
            keys: Vec::new(),
        }
    }

    fn insert(&mut self, val: i32) -> bool {
        if self.map.contains_key(&val) {
            return false;
        }
        self.map.insert(val, self.keys.len() as i32);
        self.keys.push(val);
        true
    }

    fn remove(&mut self, val: i32) -> bool {
        if !self.map.contains_key(&val) {
            return false;
        }
        let index = *self.map.get(&val).unwrap();
        if index != self.keys.len() as i32 - 1 {
            let last = *self.keys.last().unwrap();
            self.keys.insert(index as usize, last);
            self.map.insert(last, index);
        }
        self.map.remove(&val);
        self.keys.pop();
        true
    }

    fn get_random(&self) -> i32 {
        self.keys[rand::thread_rng().gen_range(0..self.keys.len())]
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {}
}
