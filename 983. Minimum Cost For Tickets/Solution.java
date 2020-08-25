import java.util.*;
import java.util.stream.*;

class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    private int[] days;
    private int t1, t7, t30;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        t1 = costs[0];
        t7 = costs[1];
        t30 = costs[2];
        return minCostFrom(0, 0);
    }

    private int minCostFrom(int i, int validUntil) {
        if (i >= days.length) {
            return 0;
        }
        var day = days[i];
        if (day <= validUntil) {
            return minCostFrom(i + 1, validUntil);
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        var cost = IntStream.of(t1 + minCostFrom(i + 1, day), t7 + minCostFrom(i + 1, day + 6), t30 + minCostFrom(i + 1, day + 29))
            .min()
            .getAsInt();
        cache.put(i, cost);
        return cost;
    }

    // java Solution.java "[1,4,6,7,8,20]" "[2,7,15]" "11" "[1,2,3,4,5,6,7,8,9,10,30,31]" "[2,7,15]" "17"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String days = args[i], costs = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: days = %s, costs = %s",
                new Solution().mincostTickets(intArr(days), intArr(costs)), expected, days, costs));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
