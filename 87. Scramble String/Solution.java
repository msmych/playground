class Solution {

    public boolean isScramble(String s1, String s2) {
        var dp = new boolean[s1.length()][s1.length()][s1.length() + 1];
        for (var k = 1; k <= s1.length(); k++) {
            for (var i = 0; i + k <= s1.length(); i++) {
                for (int j = 0; j + k <= s1.length(); j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (var q = 1; q < k && !dp[i][j][k]; q++) {
                            dp[i][j][k] = (dp[i][j][q] && dp[i + q][j + q][k - q]) || (dp[i][j + k - q][q] && dp[i + q][j][k - q]);
                        }
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }

    // java Solution.java "great" "rgeat" "true" "abcde" "caebd" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s1 = args[i], s2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s1 = %s, s2 = %s",
                new Solution().isScramble(s1, s2), expected, s1, s2));
        }
    }
}
