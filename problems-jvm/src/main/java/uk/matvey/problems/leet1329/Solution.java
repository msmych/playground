package uk.matvey.problems.leet1329;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

public class Solution {

    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 1) {
            return mat;
        }
        for (int i = 0; i < mat.length - 1; i++) {
            var arr = new int[Math.min(mat.length - i, mat[0].length)];
            for (int j = 0; j < Math.min(mat.length - i, mat[0].length); j++) {
                arr[j] = mat[i + j][j];
            }
            Arrays.sort(arr);
            for (int j = 0; j < Math.min(mat.length - i, mat[0].length); j++) {
                mat[i + j][j] = arr[j];
            }
        }
        for (int j = 1; j < mat[0].length - 1; j++) {
            var arr = new int[Math.min(mat.length, mat[0].length - j)];
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

class SolutionTest {

    @Test
    public void case1() {
        int[][] mat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
            .contains(new int[]{1, 1, 1, 1}, atIndex(0))
            .contains(new int[]{1, 2, 2, 2}, atIndex(1))
            .contains(new int[]{1, 2, 3, 3}, atIndex(2));
    }

    @Test
    public void case2() {
        int[][] mat = new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
            .contains(new int[]{5, 17, 4, 1, 52, 7}, atIndex(0))
            .contains(new int[]{11, 11, 25, 45, 8, 69}, atIndex(1))
            .contains(new int[]{14, 23, 25, 44, 58, 15}, atIndex(2))
            .contains(new int[]{22, 27, 31, 36, 50, 66}, atIndex(3))
            .contains(new int[]{84, 28, 75, 33, 55, 68}, atIndex(4));
    }

    @Test
    public void case3() {
        int[][] mat = new int[][]{{37, 98, 82, 45, 42}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
            .contains(new int[]{37, 98, 82, 45, 42}, atIndex(0));
    }

    @Test
    public void case4() {
        int[][] mat = new int[][]{{75, 21, 13, 24, 8}, {24, 100, 40, 49, 62}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
            .contains(new int[]{75, 21, 13, 24, 8}, atIndex(0))
            .contains(new int[]{24, 100, 40, 49, 62}, atIndex(1));
    }
}
