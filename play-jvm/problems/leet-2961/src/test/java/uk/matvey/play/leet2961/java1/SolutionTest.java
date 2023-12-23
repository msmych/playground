package uk.matvey.play.leet2961.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var variables = new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};

        List<Integer> result = new Solution().getGoodIndices(variables, 2);

        assertThat(result).containsExactly(0, 2);
    }

    @Test
    public void case2() {
        var variables = new int[][]{{39, 3, 1000, 1000}};

        List<Integer> result = new Solution().getGoodIndices(variables, 17);

        assertThat(result).isEmpty();
    }

    @Test
    public void case3() {
        var variables = new int[][]{{2, 2, 3, 2}, {1, 3, 3, 2}, {3, 2, 2, 3}, {3, 1, 2, 3}, {1, 2, 3, 1}, {2, 2, 2, 2}, {2, 1, 3, 1}, {3, 2, 2, 2}, {2, 1, 3, 1}, {3, 3, 1, 3}};

        List<Integer> result = new Solution().getGoodIndices(variables, 0);

        assertThat(result).containsExactly(0, 2, 3, 4, 5, 6, 8);
    }

    @Test
    public void case4() {
        var variables = new int[][]{{5, 6, 5, 1}, {4, 3, 1, 6}, {5, 4, 4, 2}};

        List<Integer> result = new Solution().getGoodIndices(variables, 4);

        assertThat(result).containsExactly(1);
    }

    @Test
    public void case5() {
        var variables = new int[][]{{4, 8, 3, 3}, {2, 5, 6, 6}, {3, 1, 3, 5}, {5, 8, 8, 1}, {6, 4, 3, 9}, {3, 8, 8, 6}, {3, 5, 8, 9}};

        List<Integer> result = new Solution().getGoodIndices(variables, 0);

        assertThat(result).containsExactly(0, 3, 4, 6);
    }

    @Test
    public void case6() {
        var variables = new int[][]{{50, 8, 16, 47}, {24, 25, 53, 53}, {33, 33, 59, 11}, {33, 51, 31, 42}, {25, 50, 48, 36}, {62, 12, 34, 35}, {29, 40, 52, 6}, {34, 21, 47, 26}, {25, 15, 57, 5}, {57, 30, 3, 15}};

        List<Integer> result = new Solution().getGoodIndices(variables, 40);

        assertThat(result).isEmpty();
    }
}
