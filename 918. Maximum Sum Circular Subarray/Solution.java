import java.util.stream.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

class Solution {
    public int maxSubarraySumCircular(int[] A) {
        long sum = stream(A).sum();
        return (int) LongStream.of(
            kadane(A, 0, A.length, 1), 
            sum + kadane(A, 1, A.length, -1), 
            sum + kadane(A, 0, A.length - 1, -1))
            .max()
            .getAsLong();
    }

    private int kadane(int[] arr, int i, int j, int sign) {
        var max = Integer.MIN_VALUE;
        var n = Integer.MIN_VALUE;
        for (var k = i; k < j; k++) {
            n = sign * arr[k] + max(n, 0);
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    // java Solution.java "[1,-2,3,-2]" "3" "[5,-3,5]" "10" "[3,-1,2,-1]" "4" "[3,-2,2,-3]" "3" "[-2,-3,-1]" "-1" "[3,1,3,2,6]" 15 "[-2]" -2
    public static void main(String... args) {
        new Solution().maxSubarraySumCircular(array("[5,-3,5]"));
        for (int i = 0; i < args.length; i += 2) {
            String A = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s",
                new Solution().maxSubarraySumCircular(array(A)), expected, A));
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
