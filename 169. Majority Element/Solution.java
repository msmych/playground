import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public int majorityElement(int[] nums) {
        return stream(nums)
            .mapToObj(n -> n)
            .collect(groupingBy(n -> n, summingInt(n -> 1)))
            .entrySet().stream()
            .filter(e -> e.getValue() > nums.length / 2)
            .map(Map.Entry::getKey)
            .findAny()
            .orElseThrow();
    }

    // java Solution.java "[3,2,3]" "3" "[2,2,1,1,1,2,2]" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().majorityElement(intArr(nums)), expected, nums));
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
