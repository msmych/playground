import java.util.stream.*;

import static java.util.stream.IntStream.*;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        return range(0, n).flatMap(i -> IntStream.of(nums[i], nums[i + n])).toArray();
    }

    // java Solution.java "[2,5,1,3,4,7]" "3" "[2,3,5,4,1,7]" "[1,2,3,4,4,3,2,1]" "4" "[1,4,2,3,3,2,4,1]" "[1,1,2,2]" "2" "[1,2,1,2]"
    public static void main(String... args) {
        new Solution().shuffle(array("[1,2,3,4,4,3,2,1]"), 4);
        for (int i = 0; i < args.length; i += 3) {
            String nums = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s, n = %s",
                string(new Solution().shuffle(array(nums), Integer.parseInt(n))), expected, nums, n));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
