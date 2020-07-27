import static java.lang.Math.*;
class Solution {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = nums[0], max = nums[0];
        for (var i = 1; i < nums.length; i++) {
            sum = max(nums[i], sum + nums[i]);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    // java Solution.java "[-2,1,-3,4,-1,2,1,-5,4]" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().maxSubArray(array(nums)), expected, nums));
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
