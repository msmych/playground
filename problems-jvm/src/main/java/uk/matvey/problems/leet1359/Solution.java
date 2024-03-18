package uk.matvey.problems.leet1359;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int countOrders(int n) {
        int mod = 1_000_000_007;
        long orders = 1;
        for (int i = 1; i <= n; i++) {
            orders = orders * (2 * i - 1) * i % mod;
        }
        return (int) orders;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().countOrders(1)).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().countOrders(2)).isEqualTo(6);
    }

    @Test
    public void case3() {
        assertThat(new Solution().countOrders(3)).isEqualTo(90);
    }

    @Test
    public void case4() {
        assertThat(new Solution().countOrders(444)).isEqualTo(693487723);
    }
}
