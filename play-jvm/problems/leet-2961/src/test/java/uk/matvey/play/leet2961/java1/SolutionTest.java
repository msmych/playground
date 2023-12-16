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
        var variables = new int[][]{{39,3,1000,1000}};

        List<Integer> result = new Solution().getGoodIndices(variables, 17);

        assertThat(result).isEmpty();
    }
}
