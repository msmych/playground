package uk.matvey.play.leet1344.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        double result = new Solution().angleClock(12, 30);

        assertThat(result).isEqualTo(165.0);
    }

    @Test
    public void case2() {
        double result = new Solution().angleClock(3, 30);

        assertThat(result).isEqualTo(75.0);
    }

    @Test
    public void case3() {
        double result = new Solution().angleClock(3, 15);

        assertThat(result).isEqualTo(7.5);
    }

    @Test
    public void case4() {
        double result = new Solution().angleClock(4, 50);

        assertThat(result).isEqualTo(155);
    }

    @Test
    public void case5() {
        double result = new Solution().angleClock(12, 0);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case6() {
        double result = new Solution().angleClock(1, 57);

        assertThat(result).isEqualTo(76.5);
    }
}
