import java.util.*;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        var queue = new LinkedList<Integer>();
        for (var i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        var max = new int[nums.length - k + 1];
        for (var i = k; i < nums.length; i++) {
            max[i - k] = queue.stream().mapToInt(n -> n).max().getAsInt();
            queue.poll();
            queue.offer(nums[i]);
        }
        max[nums.length - k] = queue.stream().mapToInt(n -> n).max().getAsInt();
        return max;
    }

    // java Solution.java "[1,3,-1,-3,5,3,6,7]" "3" "[3,3,5,5,6,7]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, k = %s",
                string(new Solution().maxSlidingWindow(intArr(nums), Integer.parseInt(k))), expected, nums, k));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
