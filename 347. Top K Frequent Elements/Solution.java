import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        return stream(nums)
            .boxed()
            .collect(groupingBy(n -> n, summingInt(n -> 1)))
            .entrySet().stream()
            .sorted(comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue()).reversed())
            .map(Map.Entry::getKey)
            .limit(k)
            .mapToInt(n -> n)
            .toArray();
    }

    // java Solution.java "[1,1,1,2,2,3]" "2" "[1,2]" "[1]" "1" "[1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                string(new Solution().topKFrequent(array(nums), Integer.parseInt(k))), expected, nums, k));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
