import java.util.*;

import static java.lang.Math.*;

class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    private int[] nums;

    public int rob(int[] nums) {
        this.nums = nums;
        return robNext(0);
    }

    private int robNext(int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        var max = max(robNext(i + 1), nums[i] + robNext(i + 2));
        cache.put(i, max);
        return max;
    }

    // java Solution.java "[1,2,3,1]" "4" "[2,7,9,3,1]" "12"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().rob(intArr(nums)), expected, nums));
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
