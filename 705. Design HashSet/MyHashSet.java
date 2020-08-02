import java.util.*;

class MyHashSet {
    
    private final List[] buckets = new List[1000];

    public MyHashSet() {}
    
    public void add(int key) {
        var hash = hashCode(key);
        var bucket = buckets[hash];
        if (bucket == null) {
            bucket = new ArrayList(1000);
        }
        for (var k : bucket) {
            if (k.equals(key)) {
                return;
            }
        }
        bucket.add(key);
        buckets[hash] = bucket;
    }
    
    public void remove(int key) {
        var bucket = buckets[hashCode(key)];
        if (bucket == null) {
            return;
        }
        var iterator = bucket.iterator();
        while (iterator.hasNext()) {
            var k = iterator.next();
            if (k.equals(key)) {
                iterator.remove();
                return;
            }
        }
    }
    
    public boolean contains(int key) {
        var bucket = buckets[hashCode(key)];
        if (bucket == null) {
            return false;
        }
        for (var k : bucket) {
            if (k.equals(key)) {
                return true;
            }
        }
        return false;
    }
    
    private int hashCode(int key) {
        return key % 1000;
    }
}
