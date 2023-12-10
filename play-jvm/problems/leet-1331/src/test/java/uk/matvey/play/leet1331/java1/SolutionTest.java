package uk.matvey.play.leet1331.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{40, 10, 20, 30};

        int[] result = new Solution().arrayRankTransform(arr);

        assertThat(result).containsExactly(4, 1, 2, 3);
    }

    @Test
    public void case2() {
        var arr = new int[]{100, 100, 100};

        int[] result = new Solution().arrayRankTransform(arr);

        assertThat(result).containsExactly(1, 1, 1);
    }

    @Test
    public void case3() {
        var arr = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};

        int[] result = new Solution().arrayRankTransform(arr);

        assertThat(result).containsExactly(5, 3, 4, 2, 8, 6, 7, 1, 3);
    }
}
