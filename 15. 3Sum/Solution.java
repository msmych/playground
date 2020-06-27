import java.util.*;

import static java.util.Arrays.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        var triplets = new LinkedList<List<Integer>>();
        for (var i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1, first = -nums[i];
            while (left < right) {
                var secondThird = nums[left] + nums[right];
                if (secondThird == first) {
                    triplets.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (secondThird < first) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }

    // java Solution.java "[-1, 0, 1, 2, -1, -4]" "[[-1, 0, 1],[-1, -1, 2]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().threeSum(array(nums)), expected, nums));
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
