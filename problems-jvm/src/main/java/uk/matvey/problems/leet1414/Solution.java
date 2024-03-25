package uk.matvey.problems.leet1414;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int findMinFibonacciNumbers(int k) {
        if (k < 2) {
            return k;
        }
        int i = 1, j = 1;
        while (j <= k) {
            j += i;
            i = j - i;
        }
        return 1 + findMinFibonacciNumbers(k - i);
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().findMinFibonacciNumbers(7)).isEqualTo(2);
    }

    @Test
    void case2() {
        assertThat(new Solution().findMinFibonacciNumbers(10)).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(new Solution().findMinFibonacciNumbers(19)).isEqualTo(3);
    }
}
