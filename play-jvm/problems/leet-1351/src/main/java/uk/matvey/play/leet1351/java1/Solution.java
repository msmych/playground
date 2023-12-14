package uk.matvey.play.leet1351.java1;

public class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    neg++;
                } else if (j == grid.length - 1) {
                    return neg;
                } else {
                    break;
                }
            }
        }
        return neg;
    }
}
