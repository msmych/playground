import static java.lang.Math.max;
import static java.util.Arrays.stream;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        var dp = new int[text1.length() + 1][text2.length() + 1];
        for (var i = 0; i < text1.length(); i++) {
            for (var j = 0; j < text2.length(); j++) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                    ? dp[i][j] + 1
                    : max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return stream(dp)
            .mapToInt(row -> stream(row).max().orElse(0))
            .max().orElse(0);
    }

    // java Solution.java "abcde" "ace" "3" "abc" "abc" "3" "abc" "def" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String text1 = args[i], text2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: text1 = %s, text2 = %s",
                new Solution().longestCommonSubsequence(text1, text2), expected, text1, text2));
        }
    }
}
