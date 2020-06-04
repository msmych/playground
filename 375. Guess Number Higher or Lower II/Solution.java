import static java.lang.Math.*;

class Solution {
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        var dp = new int[n + 1][n + 1];
        for (var d = 1; d < n; d++) {
            for (var i = 0; i + d <= n; i++) {
                var j = i + d;
                dp[i][j] = Integer.MAX_VALUE;
                for (var k = i; k <= j; k++) {
                    dp[i][j] = min(dp[i][j], k + max(k - 1 >= i ? dp[i][k - 1] : 0, j >= k + 1 ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[1][n];
    }

    // java Solution.java 
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().getMoneyAmount(Integer.parseInt(n)), expected, n));
        }
    }
}
