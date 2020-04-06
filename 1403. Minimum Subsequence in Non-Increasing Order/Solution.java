import java.util.List;
import java.util.ArrayList;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        sort(nums);
        var sub = new ArrayList<Integer>();
        var leftSum = 0;
        var rightSum = stream(nums).sum();
        for (var i = nums.length - 1; leftSum <= rightSum; i--) {
            sub.add(nums[i]);
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return sub;
    }

    // java Solution.java "[4,3,10,9,8]" "[10,9]" "[4,4,7,6,7]" "[7,7,6]" "[6]" "[6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().minSubsequence(array(nums)), expected, nums));
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
