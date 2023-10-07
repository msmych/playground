package uk.matvey.play.leet1420.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().numOfArrays(2, 3, 1);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        int result = new Solution().numOfArrays(5, 2, 3);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().numOfArrays(9, 1, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        int result = new Solution().numOfArrays(50, 100, 25);

        assertThat(result).isEqualTo(34549172);
    }
}
