import static java.util.Arrays.*;
import static java.util.Comparator.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        sort(envelopes, comparingInt((int[] envelope) -> envelope[0])
            .thenComparing((int[] envelope) -> envelope[1], reverseOrder()));
        var dp = new int[envelopes.length];
        var len = 0;
        for (var envelope : envelopes) {
            var index = binarySearch(dp, 0, len, envelope[1]);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    // java Solution.java "[[5,4],[6,4],[6,7],[2,3]]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String envelopes = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: envelopes = %s",
                new Solution().maxEnvelopes(array(envelopes)), expected, envelopes));
        }
    }

    private static int[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new int[0][0];
        int[][] arr = new int[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.parseInt(elements[j]);
        }
        return arr;
    }
}
