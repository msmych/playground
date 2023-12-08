package uk.matvey.play.leet1323.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().maximum69Number(9669);

        assertThat(result).isEqualTo(9969);
    }

    @Test
    public void case2() {
        int result = new Solution().maximum69Number(9996);

        assertThat(result).isEqualTo(9999);
    }

    @Test
    public void case3() {
        int result = new Solution().maximum69Number(9999);

        assertThat(result).isEqualTo(9999);
    }
}
