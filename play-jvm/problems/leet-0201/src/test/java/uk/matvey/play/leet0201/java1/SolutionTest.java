package uk.matvey.play.leet0201.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().rangeBitwiseAnd(5, 7);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        int result = new Solution().rangeBitwiseAnd(0, 0);

        assertThat(result).isEqualTo(0);
    }
}