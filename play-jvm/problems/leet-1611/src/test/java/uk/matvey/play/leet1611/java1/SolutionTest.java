package uk.matvey.play.leet1611.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minimumOneBitOperations(3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        int result = new Solution().minimumOneBitOperations(6);

        assertThat(result).isEqualTo(4);
    }
}
