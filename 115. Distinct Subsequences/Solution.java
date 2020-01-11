import static java.util.Arrays.fill;
import static java.util.Arrays.stream;

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        fill(dp[0], 1);
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i + 1][j + 1] = t.charAt(i) == s.charAt(j) 
                    ? dp[i][j] + dp[i + 1][j] : dp[i + 1][j];
            }
        }
        return stream(dp[dp.length - 1]).max().orElse(0);
    }

    // java Solution.java rabbbit rabbit 3 babgbag bag 5
    public static void main(String... args) {
        Solution solution = new Solution();
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], t = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, t = %s", 
                solution.numDistinct(s, t), expected, s, t));
        }
    }
}
