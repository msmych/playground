package uk.matvey.play.leet1326.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var ranges = new int[]{3, 4, 1, 1, 0, 0};

        int result = new Solution().minTaps(5, ranges);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        var ranges = new int[]{0,0,0,0};

        int result = new Solution().minTaps(3, ranges);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void case3() {
        var ranges = new int[]{1,2,1,0,2,1,0,1};

        int result = new Solution().minTaps(7, ranges);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case4() {
        var ranges = new int[]{4,0,0,0,0,0,0,0,4};

        int result = new Solution().minTaps(8, ranges);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case5() {
        var ranges = new int[]{4,0,0,0,4,0,0,0,4};

        int result = new Solution().minTaps(8, ranges);

        assertThat(result).isEqualTo(1);
    }
}
