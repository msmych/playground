package uk.matvey.play.leet1362.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
