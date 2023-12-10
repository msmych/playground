package uk.matvey.play.leet1342.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().numberOfSteps(14);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        int result = new Solution().numberOfSteps(8);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        int result = new Solution().numberOfSteps(123);

        assertThat(result).isEqualTo(12);
    }
}
