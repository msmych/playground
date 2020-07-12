import java.util.stream.*;

import static java.util.Arrays.*;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        sort(nums);
        var n = nums.length - 1;
        return IntStream.of(
            nums[n] - nums[3],
            nums[n - 1] - nums[2],
            nums[n - 2] - nums[1],
            nums[n - 3] - nums[0])
            .min()
            .getAsInt();
    }

    // java Solution.java "[5,3,2,4]" "0" "[1,5,0,10,14]" "1" "[6,6,0,1,1,4,6]" "2" "[1,5,6,14,15]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().minDifference(array(nums)), expected, nums));
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
