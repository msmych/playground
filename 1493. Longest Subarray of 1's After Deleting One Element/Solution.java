import static java.util.Arrays.*;

class Solution {
    public int longestSubarray(int[] nums) {
        if (stream(nums).noneMatch(num -> num == 0)) {
            return nums.length - 1;
        }
        int left = 0, right = 0, zeroes = 0, max = 0;
        for (var num : nums) {
            if (num == 0) {
                zeroes++;
                if (zeroes == 1) {
                    if (left + right > max) {
                        max = left + right;
                    }
                    left = right;
                    right = 0;
                } else {
                    if (left + right > max) {
                        max = left + right;
                    }
                    left = 0;
                    right = 0;
                }
            } else {
                right++;
                zeroes = 0;
            }
        }
        if (left + right > max) {
            max = left + right;
        }
        return max;
    }

    // java Solution.java "[1,1,0,1]" "3" "[0,1,1,1,0,1,1,0,1]" "5" "[1,1,1]" "2" "[1,1,0,0,1,1,1,0,1]" "4" "[0,0,0]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().longestSubarray(array(nums)), expected, nums));
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
