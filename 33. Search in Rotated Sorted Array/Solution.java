import java.util.*;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int[] leftNums = null, rightNums = null;
        for (var i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                leftNums = Arrays.copyOfRange(nums, i + 1, nums.length);
                rightNums = Arrays.copyOf(nums, i + 1);
                break;
            }
        }
        if (leftNums == null) {
            leftNums = nums;
            rightNums = new int[0];
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = mid < leftNums.length ? leftNums[mid] : rightNums[mid - leftNums.length];
            if (val == target) {
                return mid < leftNums.length ? mid + rightNums.length : mid - leftNums.length;
            } else if (val > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // java Solution.java "[4,5,6,7,0,1,2]" "0" "4" "[4,5,6,7,0,1,2]" "3" "-1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, target = %s",
                new Solution().search(array(nums), Integer.parseInt(target)), expected, nums, target));
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
