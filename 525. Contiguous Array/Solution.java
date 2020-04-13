import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var max = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            map.putIfAbsent(count, i);
            var len = i - map.get(count);
            if (len > max) {
                max = len;
            }
            if (count == 0 && i + 1 > max) {
                max = i + 1;
            }
        }
        return max;
    }

    // java Solution.java "[0,1]" "2" "[0,1,0]" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().findMaxLength(array(nums)), expected, nums));
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
