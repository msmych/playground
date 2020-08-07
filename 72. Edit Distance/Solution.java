import java.util.stream.*;

class Solution {

    public int minDistance(String word1, String word2) {
        var dp = new int[word1.length() + 1][word2.length() + 1];
        for (var i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (var j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
        for (var i = 0; i < word1.length(); i++) {
            for (var j = 0; j < word2.length(); j++) {
                dp[i + 1][j + 1] = word1.charAt(i) == word2.charAt(j)
                    ? dp[i][j]
                    : IntStream.of(dp[i + 1][j], dp[i][j + 1], dp[i][j]).min().getAsInt() + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // java Solution.java "horse" "ros" "3" "intention" "execution" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String word1 = args[i], word2 = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: word1 = %s, word2 = %s",
                new Solution().minDistance(word1, word2), expected, word1, word2));
        }
    }
}
