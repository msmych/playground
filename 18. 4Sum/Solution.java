import java.util.*;

import static java.util.Arrays.*;
import static java.util.Collections.*;

class Solution {

    private int[] nums;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.nums = nums;
        sort(nums);
        return nextSum(4, 0, target);
    }

    private List<List<Integer>> nextSum(int k, int index, int target) {
        if (index >= nums.length) {
            return emptyList();
        }
        if (k == 2) {
            return twoSum(index, target);
        }
        var sums = new ArrayList<List<Integer>>();
        for (var i = index; i < nums.length - k + 1; i++) {
            var nextSums = nextSum(k - 1, i + 1, target - nums[i]);
            for (var nextSum : nextSums) {
                nextSum.add(0, nums[i]);
            }
            sums.addAll(nextSums);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return sums;
    }

    private List<List<Integer>> twoSum(int index, int target) {
        var pairs = new ArrayList<List<Integer>>();
        int i = index, j = nums.length - 1;
        while (i < j) {
            var sum = nums[i] + nums[j];
            if (sum == target) {
                var pair = new ArrayList<Integer>();
                pair.add(nums[i]);
                pair.add(nums[j]);
                pairs.add(pair);
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (sum < target){
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }

    // java Solution.java "[1, 0, -1, 0, -2, 2]" "0" "[[-1,  0, 0, 1],[-2, -1, 1, 2],[-2,  0, 0, 2]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, target = %s",
                new Solution().fourSum(array(nums), Integer.parseInt(target)), expected, nums, target));
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
