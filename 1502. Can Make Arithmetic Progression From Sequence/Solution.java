import static java.util.Arrays.*;
import static java.util.stream.IntStream.*;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        sort(arr);
        return range(1, arr.length)
            .map(i -> arr[i] - arr[i - 1])
            .distinct()
            .count() == 1;
    }

    // java Solution.java "[3,5,1]" "true" "[1,2,4]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String arr = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s",
                new Solution().canMakeArithmeticProgression(array(arr)), expected, arr));
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
