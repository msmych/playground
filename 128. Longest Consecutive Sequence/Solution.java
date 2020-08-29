import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> fromIntervals = new HashMap<>(), toIntervals = new HashMap<>();
        for (var num : nums) {
            if (fromIntervals.containsKey(num) || toIntervals.containsKey(num)) {
                continue;
            }
            if (!fromIntervals.containsKey(num + 1) && !toIntervals.containsKey(num - 1)) {
                fromIntervals.put(num, num);
                toIntervals.put(num, num);
            } else if (fromIntervals.containsKey(num + 1)) {
                var to = fromIntervals.get(num + 1);
                fromIntervals.remove(num + 1);
                fromIntervals.put(num, to);
                toIntervals.put(to, num);
            } else {
                var from = toIntervals.get(num - 1);
                toIntervals.remove(num - 1);
                toIntervals.put(num, from);
                fromIntervals.put(from, num);
            }
        }
        for (var join : toIntervals.keySet().stream().filter(to -> fromIntervals.containsKey(to + 1)).collect(toList())) {
            int from = toIntervals.get(join), to = fromIntervals.get(join + 1);
            fromIntervals.put(from, to);
            toIntervals.put(to, from);
            fromIntervals.remove(join + 1);
            toIntervals.remove(join);
        }
        return fromIntervals.entrySet().stream().mapToInt(entry -> entry.getValue() - entry.getKey() + 1).max().orElse(0);
    }

    // java Solution.java "[100, 4, 200, 1, 3, 2]" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().longestConsecutive(intArr(nums)), expected, nums));
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
