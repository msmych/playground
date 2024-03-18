package uk.matvey.problems.leet1362;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] closestDivisors(int num) {
        for (int i = ((int) Math.sqrt(num)) + 1; i > 1; i--) {
            if ((num + 1) % i == 0) {
                return new int[]{i, (num + 1) / i};
            } else if ((num + 2) % i == 0) {
                return new int[]{i, (num + 2) / i};
            }
        }
        return new int[]{1, num + 1};
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().closestDivisors(8)).containsExactly(3, 3);
    }

    @Test
    public void case2() {
        assertThat(new Solution().closestDivisors(123)).containsExactly(5, 25);
    }

    @Test
    public void case3() {
        assertThat(new Solution().closestDivisors(999)).containsExactlyInAnyOrder(40, 25);
    }

    @Test
    public void case4() {
        assertThat(new Solution().closestDivisors(999999999)).containsExactly(31250, 32000);
    }

    @Test
    public void case5() {
        assertThat(new Solution().closestDivisors(2)).containsExactly(2, 2);
    }
}
