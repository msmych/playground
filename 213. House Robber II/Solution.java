import java.util.*;

import static java.lang.Math.*;

class Solution {

    private final Map<Integer, Integer> pickedFirstCache = new HashMap<>();
    private final Map<Integer, Integer> notPickedFirstCache = new HashMap<>();

    private int[] nums;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;
        return max(robNextPickedFirst(0), robNextNotPickedFirst(1));
    }

    private int robNextPickedFirst(int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (pickedFirstCache.containsKey(i)) {
            return pickedFirstCache.get(i);
        }
        int max = max(robNextPickedFirst(i + 1), nums[i] + robNextPickedFirst(i + 2));
        pickedFirstCache.put(i, max);
        return max;
    }

    private int robNextNotPickedFirst(int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        if (notPickedFirstCache.containsKey(i)) {
            return notPickedFirstCache.get(i);
        }
        int max = max(robNextNotPickedFirst(i + 1), nums[i] + robNextNotPickedFirst(i + 2));
        notPickedFirstCache.put(i, max);
        return max;
    }

    // java Solution.java "[2,3,2]" "3" "[1,2,3,1]" "4"
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
