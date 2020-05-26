import java.util.*;

import static java.util.Arrays.*;


class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        sort(nums);
        var arr = new int[nums.length];
        var parent = new int[nums.length];
        fill(parent, -1);
        arr[0] = 1;
        var max = 0;
        var maxIndex = 0;
        for (var i = 1; i < nums.length; i++) {
            arr[i] = 1;
            for (var j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (arr[j] + 1 > arr[i]) {
                        arr[i] = arr[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        var subset = new ArrayList<Integer>();
        for (var i = maxIndex; i >= 0; i = parent[i]) {
            subset.add(0, nums[i]);
        }
        return subset;
    }

    // java Solution.java "[1,2,3]" "[1,2]" "[1,2,4,8]" "[1,2,4,8]" "[2,3,8,9,27]" "[3,9,27]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().largestDivisibleSubset(array(nums)), expected, nums));
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
}
