import static java.util.Arrays.*;
import static java.util.Comparator.*;

class Solution {
    public int maxProduct(int[] nums) {
        return stream(nums)
            .boxed()
            .sorted(reverseOrder())
            .limit(2)
            .mapToInt(n -> n - 1)
            .reduce((a, b) -> a * b)
            .getAsInt();
    }

    // java Solution.java "[3,4,5,2]" "12" "[1,5,4,5]" "16" "[3,7]" "12"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().maxProduct(array(nums)), expected, nums));
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
