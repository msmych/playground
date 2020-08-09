import java.util.*;

import static java.util.Arrays.*;

class Solution {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1, pivot = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[0] && nums[mid] == nums[nums.length - 1]) {
                return stream(nums).anyMatch(n -> n == target);
            }
            if (nums[mid] > nums[mid + 1]) {
                pivot = mid + 1;
                break;
            }
            if (nums[mid] > nums[0] || nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (pivot == -1) {
            pivot = right + 1;
        }
        int[] leftNums = Arrays.copyOfRange(nums, pivot, nums.length), rightNums = Arrays.copyOf(nums, pivot);
        System.arraycopy(leftNums, 0, nums, 0, leftNums.length);
        System.arraycopy(rightNums, 0, nums, leftNums.length, rightNums.length);
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    // java Solution.java "[2,5,6,0,0,1,2]" "0" "true" "[2,5,6,0,0,1,2]" "3" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, target = %s",
                new Solution().search(intArr(nums), Integer.parseInt(target)), expected, nums, target));
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
