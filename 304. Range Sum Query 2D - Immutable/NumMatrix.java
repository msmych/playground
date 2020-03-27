class NumMatrix {

    private final int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            dp = new int[0][0];
            return;
        }
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + matrix[i][j] - dp[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String... args) {
        var matrix = new NumMatrix(new int[][]{
            {3,0,1,4,2},
            {5,6,3,2,1},
            {1,2,0,1,5},
            {4,1,0,1,7},
            {1,0,3,0,5}
        });
        System.out.println(String.format("Output: %s | Expected: %s", matrix.sumRegion(2, 1, 4, 3), 8));
        System.out.println(String.format("Output: %s | Expected: %s", matrix.sumRegion(1, 1, 2, 2), 11));
        System.out.println(String.format("Output: %s | Expected: %s", matrix.sumRegion(1, 2, 2, 4), 12));
        new NumMatrix(new int[0][0]);
    }
}
