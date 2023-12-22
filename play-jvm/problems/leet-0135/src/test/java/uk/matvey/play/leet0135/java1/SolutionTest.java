package uk.matvey.play.leet0135.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var ratings = new int[]{1, 0, 2};

        int result = new Solution().candy(ratings);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        var ratings = new int[]{1, 2, 2};

        int result = new Solution().candy(ratings);

        assertThat(result).isEqualTo(4);
    }
}
