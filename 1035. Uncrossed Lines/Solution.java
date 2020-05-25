import static java.lang.Math.*;

class Solution {

    public int maxUncrossedLines(int[] A, int[] B) {
        var dp = new int[A.length + 1][B.length + 1];
        for (var i = 1; i <= A.length; i++) {
            for (var j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }

    // java Solution.java "[1,4,2]" "[1,2,4]" "2" "[2,5,1,2,5]" "[10,5,2,1,5,2]" 3 "[1,3,7,1,7,5]" "[1,9,2,5,1]" 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String A = args[i], B = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s, B = %s",
                new Solution().maxUncrossedLines(array(A), array(B)), expected, A, B));
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
