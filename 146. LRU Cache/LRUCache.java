import java.util.*;

class LRUCache {

    private List<Integer> keys;
    private int capacity;
    private final Map<Integer, Integer> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        keys = new ArrayList<>(capacity);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        updateKeys(key);
        return map.get(key);
    }

    private void updateKeys(int key) {
        keys.remove(Integer.valueOf(key));
        keys.add(0, key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            updateKeys(key);
        } else if (keys.size() >= capacity) {
            var lastKey = keys.get(keys.size() - 1);
            map.remove(lastKey);
            keys.remove(Integer.valueOf(lastKey));
            keys.add(0, key);
        } else {
            keys.add(0, key);
        }
        map.put(key, value);
    }

}
