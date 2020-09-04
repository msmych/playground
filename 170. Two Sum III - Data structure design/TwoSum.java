import java.util.*;

class TwoSum {

    private final Map<Integer, Integer> vals = new HashMap<>();

    public TwoSum() {}

    public void add(int number) {
        vals.merge(number, 1, Integer::sum);
    }

    public boolean find(int value) {
        return vals.entrySet().stream()
            .anyMatch(e -> vals.containsKey(value - e.getKey()) && (value != 2 * e.getKey() || e.getValue() > 1));
    }

    public static void main(String... args) {
        var twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(String.format("Output: %s | Expected: %s", twoSum.find(4), true));
        System.out.println(String.format("Output: %s | Expected: %s", twoSum.find(7), false));
        twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(1);
        twoSum.add(2);
        System.out.println(String.format("Output: %s | Expected: %s", twoSum.find(3), true));
        System.out.println(String.format("Output: %s | Expected: %s", twoSum.find(6), false));
    }
}
