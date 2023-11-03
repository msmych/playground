package uk.matvey.play.leet0219.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 1};

        boolean result = new Solution().containsNearbyDuplicate(nums, 3);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 0, 1, 1};

        boolean result = new Solution().containsNearbyDuplicate(nums, 1);

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        var nums = new int[]{1, 2, 3, 1, 2, 3};

        boolean result = new Solution().containsNearbyDuplicate(nums, 2);

        assertThat(result).isFalse();
    }
}
