import static java.util.Arrays.*;

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (stream(nums).allMatch(i -> i == 1)) {
            return nums.length;
        }
        int left = -1, max = 1, lastMax = 1;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (left == -1) {
                    left = i;
                }
                lastMax++;
            } else {
                if (lastMax > max) {
                    max = lastMax;
                }
                lastMax = left == -1 ? 1 : i - left + 1;
                left = -1;
            }
        }
        if (lastMax > max) {
            max = lastMax;
        }
        return max;
    }

    // java Solution.java "[1,0,1,1,0]" "4" "[0,0,1,1,0,1,0,0,1,1,1,0]" 4 "[0,1,1,0,1,1,1,0,1,1,1]" 7 "[1]" 1
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findMaxConsecutiveOnes(intArr(nums)), expected, nums));
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
