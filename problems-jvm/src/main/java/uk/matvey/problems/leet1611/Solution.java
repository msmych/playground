package uk.matvey.problems.leet1611;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        int k = 0;
        int i = 1;
        while (2 * i <= n) {
            i *= 2;
            k++;
        }
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ i);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minimumOneBitOperations(3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        int result = new Solution().minimumOneBitOperations(6);

        assertThat(result).isEqualTo(4);
    }
}
