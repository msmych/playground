package uk.matvey.play.leet1314.java1;

public class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] blockSums = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int blockSum = 0;
                for (int bi = Math.max(0, i - K); bi <= Math.min(mat.length - 1, i + K); bi++) {
                    for (int bj = Math.max(0, j - K); bj <= Math.min(mat[i].length - 1, j + K); bj++) {
                        blockSum += mat[bi][bj];
                    }
                }
                blockSums[i][j] = blockSum;
            }
        }
        return blockSums;
    }
}
