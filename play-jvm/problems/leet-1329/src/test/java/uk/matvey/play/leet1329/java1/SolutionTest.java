package uk.matvey.play.leet1329.java1;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int[][] mat = new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
                .contains(new int[]{1, 1, 1, 1}, Index.atIndex(0))
                .contains(new int[]{1, 2, 2, 2}, Index.atIndex(1))
                .contains(new int[]{1, 2, 3, 3}, Index.atIndex(2));
    }

    @Test
    public void case2() {
        int[][] mat = new int[][]{{11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
                .contains(new int[]{5, 17, 4, 1, 52, 7}, Index.atIndex(0))
                .contains(new int[]{11, 11, 25, 45, 8, 69}, Index.atIndex(1))
                .contains(new int[]{14, 23, 25, 44, 58, 15}, Index.atIndex(2))
                .contains(new int[]{22, 27, 31, 36, 50, 66}, Index.atIndex(3))
                .contains(new int[]{84, 28, 75, 33, 55, 68}, Index.atIndex(4));
    }

    @Test
    public void case3() {
        int[][] mat = new int[][]{{37, 98, 82, 45, 42}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
                .contains(new int[]{37, 98, 82, 45, 42}, Index.atIndex(0));
    }

    @Test
    public void case4() {
        int[][] mat = new int[][]{{75, 21, 13, 24, 8}, {24, 100, 40, 49, 62}};

        int[][] result = new Solution().diagonalSort(mat);

        assertThat(result)
                .contains(new int[]{75, 21, 13, 24, 8}, Index.atIndex(0))
                .contains(new int[]{24, 100, 40, 49, 62}, Index.atIndex(1));
    }
}
