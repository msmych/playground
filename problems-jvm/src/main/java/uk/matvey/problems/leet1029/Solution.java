package uk.matvey.problems.leet1029;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        int min = 0;
        var refund = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
            min += costs[i][0];
        }
        Arrays.sort(refund);
        for (int i = 0; i < costs.length / 2; i++) {
            min += refund[i];
        }
        return min;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};

        int result = new Solution().twoCitySchedCost(costs);

        assertThat(result).isEqualTo(110);
    }
}
