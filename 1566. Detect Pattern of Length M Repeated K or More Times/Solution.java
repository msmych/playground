import java.util.*;

import static java.util.stream.IntStream.*;

class Solution {

    public boolean containsPattern(int[] arr, int m, int k) {
        for (var i = 0; i <= arr.length - m * k; i++) {
            var index = i;
            var pattern = Arrays.copyOfRange(arr, i, i + m);
            if (range(0, k - 1).map(n -> index + (n + 1) * m).allMatch(n -> Arrays.equals(pattern, Arrays.copyOfRange(arr, n, n + m)))) {
                return true;
            }
        }
        return false;
    }

    // java Solution.java "[1,2,4,4,4,4]" "1" "3" "true" "[1,2,1,2,1,1,1,3]" "2" "2" "true" "[1,2,1,2,1,3]" "2" "3" "false" "[1,2,3,1,2]" "2" "2" "false" "[2,2,2,2]" "2" "3" "false" "[2,2]" 1 2 true
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String arr = args[i], m = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: arr = %s, m = %s, k = %s",
                new Solution().containsPattern(intArr(arr), Integer.parseInt(m), Integer.parseInt(k)), expected, arr, m, k));
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
