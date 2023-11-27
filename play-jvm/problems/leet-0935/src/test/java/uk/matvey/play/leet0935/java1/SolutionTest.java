package uk.matvey.play.leet0935.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().knightDialer(1);

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void case2() {
        int result = new Solution().knightDialer(2);

        assertThat(result).isEqualTo(20);
    }

    @Test
    public void case3() {
        int result = new Solution().knightDialer(3131);

        assertThat(result).isEqualTo(136006598);
    }
}
