import static java.lang.Math.max;
import static java.lang.Math.min;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0) {
            return 0;
        }
        int m = dungeon.length - 1, n = dungeon[0].length - 1;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = max(1 - dungeon[m][n], 1);
        for (int i = m - 1; i >= 0; i--) {
            dp[i][n] = max(dp[i + 1][n] - dungeon[i][n], 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[m][i] = max(dp[m][i + 1] - dungeon[m][i], 1);
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int down = max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = min(right, down);
            }
        }
        return dp[0][0];
    }

    // java Solution.java "[[-2, -3, 3],[-5,-10,1],[10,30,-5]]" "7" "[[0,0]]" 1 "[[0,-3]]" 4
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String dungeon = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: dungeon = %s",
                new Solution().calculateMinimumHP(array(dungeon)), expected, dungeon));
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
