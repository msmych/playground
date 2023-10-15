package uk.matvey.play.leet1029.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};

        int result = new Solution().twoCitySchedCost(costs);

        assertThat(result).isEqualTo(110);
    }
}
