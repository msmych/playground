import java.util.*;

import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class RandomizedCollection {

    private final List<Integer> list = new ArrayList<>();
    private final Map<Integer, Set<Integer>> map = new HashMap<>();
    private final Random random = new Random();

    public RandomizedCollection() {}
    
    public boolean insert(int val) {
        var isNew = !map.containsKey(val);
        map.putIfAbsent(val, new HashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return isNew;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            var iterator = map.get(val).iterator();
            list.set(iterator.next(), null);
            iterator.remove();
            if (map.get(val).isEmpty()) {
                map.remove(val);
            }
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        var i = random.nextInt(list.size());
        for (; list.get(i) == null; i = random.nextInt(list.size())) {}
        return list.get(i);
    }

    public static void main(String... args) {
        var collection = new RandomizedCollection();
        System.out.println(String.format("Output: %s | Expected: %s", collection.insert(1), true));
        System.out.println(String.format("Output: %s | Expected: %s", collection.insert(1), false));
        System.out.println(String.format("Output: %s | Expected: %s", collection.insert(2), true));
        System.out.println(generate(() -> collection.getRandom()).limit(100).boxed().collect(groupingBy(n -> n, summingInt(n -> 1))));
        System.out.println(String.format("Output: %s | Expected: %s", collection.remove(1), true));
        System.out.println(generate(() -> collection.getRandom()).limit(100).boxed().collect(groupingBy(n -> n, summingInt(n -> 1))));
    }
}
