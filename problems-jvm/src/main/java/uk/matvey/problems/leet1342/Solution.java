package uk.matvey.problems.leet1342;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numberOfSteps (int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().numberOfSteps(14);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        int result = new Solution().numberOfSteps(8);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        int result = new Solution().numberOfSteps(123);

        assertThat(result).isEqualTo(12);
    }
}
