package uk.matvey.play.leet1318.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minFlips(2, 6, 5);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().minFlips(4, 2, 7);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        int result = new Solution().minFlips(1, 2, 3);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case4() {
        int result = new Solution().minFlips(8, 3, 5);

        assertThat(result).isEqualTo(3);
    }
}
