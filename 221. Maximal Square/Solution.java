import java.util.stream.IntStream;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length + 1];
        int max = 0;
        int last = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                int val = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = IntStream.of(dp[j - 1], last, dp[j]).min().getAsInt() + 1;
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
                last = val;
            }
        }
        return max * max;
    }

    // java Solution.java "[[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]" 4
    public static void main(String... args) {
        new Solution().maximalSquare(array("[[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]"));
        for (int i = 0; i < args.length; i += 2) {
            String matrix = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s",
                new Solution().maximalSquare(array(matrix)), expected, matrix));
        }
    }

    private static char[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new char[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new char[0][0];
        char[][] arr = new char[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = elements[j].charAt(0);
        }
        return arr;
    }
}
