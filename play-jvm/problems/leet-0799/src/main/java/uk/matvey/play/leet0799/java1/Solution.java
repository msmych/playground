package uk.matvey.play.leet0799.java1;

public class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[100][100];
        tower[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double flow = tower[i][j];
                if (flow > 1) {
                    tower[i + 1][j] += (flow - 1) / 2;
                    tower[i + 1][j + 1] += (flow - 1) / 2;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}
