package uk.matvey.play.leet0576.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().findPaths(2, 2, 2, 0, 0);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        int result = new Solution().findPaths(1, 3, 3, 0, 1);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void case3() {
        int result = new Solution().findPaths(8, 50, 23, 5, 26);

        assertThat(result).isEqualTo(914783380);
    }
}
