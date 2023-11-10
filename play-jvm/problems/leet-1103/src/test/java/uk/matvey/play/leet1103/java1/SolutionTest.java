package uk.matvey.play.leet1103.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int[] result = new Solution().distributeCandies(7, 4);

        assertThat(result).containsExactly(1, 2, 3, 1);
    }

    @Test
    public void case2() {
        int[] result = new Solution().distributeCandies(10, 3);

        assertThat(result).containsExactly(5, 2, 3);
    }
}
