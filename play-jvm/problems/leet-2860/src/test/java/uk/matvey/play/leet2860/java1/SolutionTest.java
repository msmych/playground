package uk.matvey.play.leet2860.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = List.of(1, 1);

        int result = new Solution().countWays(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var nums = List.of(6, 0, 3, 3, 6, 7, 2, 7);

        int result = new Solution().countWays(nums);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        var nums = List.of(5, 0, 3, 4, 2, 1, 2, 4);

        int result = new Solution().countWays(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var nums = List.of(2, 2, 7, 1, 2, 2, 4, 7);

        int result = new Solution().countWays(nums);

        assertThat(result).isEqualTo(3);
    }
}
