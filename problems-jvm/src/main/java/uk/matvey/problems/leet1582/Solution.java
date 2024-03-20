package uk.matvey.problems.leet1582;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numSpecial(int[][] mat) {
        var special = 0;
        var excludedRows = new HashSet<Integer>();
        var excludedCols = new HashSet<Integer>();
        for (int i = 0; i < mat.length; i++) {
            if (excludedRows.contains(i)) {
                continue;
            }
            for (int j = 0; j < mat[i].length; j++) {
                if (excludedCols.contains(j)) {
                    continue;
                }
                if (mat[i][j] == 0) {
                    continue;
                }
                int row = i, col = j;
                if (IntStream.range(0, mat.length).filter(k -> k != row).anyMatch(k -> mat[k][col] == 1)) {
                    excludedRows.add(i);
                    continue;
                }
                if (IntStream.range(0, mat[i].length).filter(k -> k != col).anyMatch(k -> mat[row][k] == 1)) {
                    excludedCols.add(j);
                    continue;
                }
                special++;
            }
        }
        return special;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var mat = new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};

        int result = new Solution().numSpecial(mat);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        var mat = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        int result = new Solution().numSpecial(mat);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        var mat = new int[][]{{0, 0, 0, 1}, {1, 0, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        int result = new Solution().numSpecial(mat);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case4() {
        var mat = new int[][]{{0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};

        int result = new Solution().numSpecial(mat);

        assertThat(result).isEqualTo(3);
    }
}
