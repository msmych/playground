package uk.matvey.play.leet1341.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};

        int[] result = new Solution().kWeakestRows(mat, 3);

        assertThat(result).containsExactly(2, 0, 3);
    }

    @Test
    public void case2() {
        var mat = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};

        int[] result = new Solution().kWeakestRows(mat, 2);

        assertThat(result).containsExactly(0, 2);
    }
}
