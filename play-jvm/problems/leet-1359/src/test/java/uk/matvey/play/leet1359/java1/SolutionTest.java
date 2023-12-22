package uk.matvey.play.leet1359.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
