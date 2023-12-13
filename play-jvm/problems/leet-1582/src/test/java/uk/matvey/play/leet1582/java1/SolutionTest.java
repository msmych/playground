package uk.matvey.play.leet1582.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
