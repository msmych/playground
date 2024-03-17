package uk.matvey.problems.leet0779;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    private int k, size = 1;

    public int kthGrammar(int N, int K) {
        for (int i = 1; i < N; i++) {
            size *= 2;
        }
        k = K;
        return next(N, "");
    }

    private int next(int n, String previous) {
        if (n == 0) {
            return previous.charAt(k - 1) - '0';
        }
        if (previous.isEmpty()) {
            return next(n - 1, "0");
        }
        if (previous.length() > 1) {
            if (k <= size / 2) {
                previous = previous.substring(0, 1);
            } else {
                previous = previous.substring(1);
                k -= size / 2;
            }
            size /= 2;
        }
        return next(n - 1, previous.equals("0") ? "01" : "10");
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().kthGrammar(1, 1);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case2() {
        int result = new Solution().kthGrammar(2, 1);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().kthGrammar(2, 2);

        assertThat(result).isEqualTo(1);
    }
}
