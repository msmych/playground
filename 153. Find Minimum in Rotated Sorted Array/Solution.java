import static java.lang.Math.*;

class Solution {

    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int leftVal = nums[0], left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < leftVal) {
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                } else {
                    right = mid - 1;
                }
            } else {
                leftVal = nums[mid];
                left = mid + 1;
            }
        }
        return min(nums[0], nums[left]);
    }

    // java Solution.java "[3,4,5,1,2]" "1" "[4,5,6,7,0,1,2]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findMin(intArr(nums)), expected, nums));
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
