struct MyHashMap {}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MyHashMap {
    fn new() -> Self {
        MyHashMap {}
    }

    fn put(&self, key: i32, value: i32) {}

    fn get(&self, key: i32) -> i32 {
        -1
    }

    fn remove(&self, key: i32) {}
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * let obj = MyHashMap::new();
 * obj.put(key, value);
 * let ret_2: i32 = obj.get(key);
 * obj.remove(key);
 */

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn case1() {
        let map = MyHashMap::new();
        map.put(1, 1);
        map.put(2, 2);
        assert_eq!(map.get(1), 1);
        assert_eq!(map.get(3), -1);
        map.put(2, 1);
        assert_eq!(map.get(2), 1);
        map.remove(2);
        assert_eq!(map.get(2), -1);
    }
}
