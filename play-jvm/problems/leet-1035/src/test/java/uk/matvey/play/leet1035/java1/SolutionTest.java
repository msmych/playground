package uk.matvey.play.leet1035.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var a = new int[]{1, 4, 2};
        var b = new int[]{1, 2, 4};

        int result = new Solution().maxUncrossedLines(a, b);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var a = new int[]{2, 5, 1, 2, 5};
        var b = new int[]{10, 5, 2, 1, 5, 2};

        int result = new Solution().maxUncrossedLines(a, b);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        var a = new int[]{1, 3, 7, 1, 7, 5};
        var b = new int[]{1, 9, 2, 5, 1};

        int result = new Solution().maxUncrossedLines(a, b);

        assertThat(result).isEqualTo(2);
    }
}
