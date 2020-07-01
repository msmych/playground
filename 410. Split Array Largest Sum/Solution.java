import static java.util.Arrays.*;

class Solution {

    private int[] nums;
    private int m;

    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        this.m = m;
        var right = stream(nums).sum();
        if (m == 1) {
            return right;
        }
        var left = stream(nums).max().getAsInt();
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (canSplit(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canSplit(int target) {
        var count = 1;
        var total = 0;
        for (var num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    // java Solution.java "[7,2,5,10,8]" "2" "18"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], m = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, m = %s",
                new Solution().splitArray(array(nums), Integer.parseInt(m)), expected, nums, m));
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
