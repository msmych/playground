package uk.matvey.play.leet2482.java1;

public class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        var rowOnes = new int[n];
        var colOnes = new int[m];
        var diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = 2 * rowOnes[i] - n + 2 * colOnes[j] - m;
            }
        }
        return diff;
    }
}
