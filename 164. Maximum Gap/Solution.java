import static java.util.Arrays.*;

class Solution {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        sort(nums);
        var maxGap = 0;
        for (var i = 0; i < nums.length - 1; i++) {
            var gap = nums[i + 1] - nums[i];
            if (gap > maxGap) {
                maxGap = gap;
            }
        }
        return maxGap;
    }

    // java Solution.java "[3,6,9,1]" "3" "[10]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().maximumGap(intArr(nums)), expected, nums));
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
