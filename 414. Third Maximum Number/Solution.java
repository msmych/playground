import static java.util.Arrays.*;
import static java.util.Comparator.*;

class Solution {
    public int thirdMax(int[] nums) {
        nums = stream(nums).distinct().toArray();
        if (nums.length < 3) {
            return stream(nums).max().orElseThrow();
        }
        return stream(nums)
            .boxed()
            .sorted(reverseOrder())
            .limit(3)
            .mapToInt(n -> n)
            .sorted()
            .findFirst()
            .orElseThrow();
    }

    // java Solution.java "[3, 2, 1]" "1" "[1, 2]" "2" "[2, 2, 3, 1]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String nums = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: nums = %s",
                new Solution().thirdMax(array(nums)), expected, nums));
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
