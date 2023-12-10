package uk.matvey.play.leet0134.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
