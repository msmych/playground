package uk.matvey.play.leet1329.java1;

import java.util.Arrays;

public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 1) {
            return mat;
        }
        for (int i = 0; i < mat.length - 1; i++) {
            int[] arr = new int[Math.min(mat.length - i, mat[0].length)];
            for (int j = 0; j < Math.min(mat.length - i, mat[0].length); j++) {
                arr[j] = mat[i + j][j];
            }
            Arrays.sort(arr);
            for (int j = 0; j < Math.min(mat.length - i, mat[0].length); j++) {
                mat[i + j][j] = arr[j];
            }
        }
        for (int j = 1; j < mat[0].length - 1; j++) {
            int[] arr = new int[Math.min(mat.length, mat[0].length - j)];
            for (int i = 0; i < Math.min(mat.length, mat[0].length - j); i++) {
                arr[i] = mat[i][j + i];
            }
            Arrays.sort(arr);
            for (int i = 0; i < Math.min(mat.length, mat[0].length - j); i++) {
                mat[i][j + i] = arr[i];
            }
        }
        return mat;
    }
}
