package uk.matvey.play.leet0220.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 1};

        boolean result = new Solution().containsNearbyAlmostDuplicate(nums, 3, 0);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 5, 9, 1, 5, 9};

        boolean result = new Solution().containsNearbyAlmostDuplicate(nums, 2, 3);

        assertThat(result).isFalse();
    }
}
