import static java.lang.Math.abs;
import static java.util.Arrays.stream;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if (stream(nums).distinct().count() == 1) {
            return nums.length;
        }
        var max = 1;
        int i = 0, j = 1;
        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            var stats = stream(nums, i, j + 1).summaryStatistics();
            if (abs(stats.getMax() - stats.getMin()) <= limit) {
                if (j - i + 1 > max) {
                    max = j - i + 1;
                }
                j++;
            } else {
                i++;
            }
        }
        return max;
    }

    // java Solution.java "[8,2,4,7]" "4" "2" "[10,1,2,4,7,2]" "5" "4" "[4,2,2,2,4,4,2,2]" "0" "3" "[4,8,5,1,7,9]" 6 3
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], limit = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, limit = %s",
                new Solution().longestSubarray(array(nums), Integer.parseInt(limit)), expected, nums, limit));
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
