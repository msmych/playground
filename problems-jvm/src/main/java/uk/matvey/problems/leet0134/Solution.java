package uk.matvey.problems.leet0134;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (var i = 0; i < gas.length; i++) {
            var canFinish = true;
            var g = 0;
            for (var j = 0; j < gas.length; j++) {
                g += gas[(i + j) % gas.length];
                g -= cost[(i + j) % cost.length];
                if (g < 0) {
                    canFinish = false;
                    break;
                }
            }
            if (canFinish) {
                return i;
            }
        }
        return -1;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var gas = new int[]{1, 2, 3, 4, 5};
        var cost = new int[]{3, 4, 5, 1, 2};

        int result = new Solution().canCompleteCircuit(gas, cost);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var gas = new int[]{2, 3, 4};
        var cost = new int[]{3, 4, 3};

        int result = new Solution().canCompleteCircuit(gas, cost);

        assertThat(result).isEqualTo(-1);
    }
}
