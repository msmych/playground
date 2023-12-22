package uk.matvey.play.leet1365.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{8, 1, 2, 2, 3};

        int[] result = new Solution().smallerNumbersThanCurrent(nums);

        assertThat(result).containsExactly(4, 0, 1, 1, 3);
    }

    @Test
    public void case2() {
        var nums = new int[]{6, 5, 4, 8};

        int[] result = new Solution().smallerNumbersThanCurrent(nums);

        assertThat(result).containsExactly(2, 1, 0, 3);
    }

    @Test
    public void case3() {
        var nums = new int[]{7, 7, 7, 7};

        int[] result = new Solution().smallerNumbersThanCurrent(nums);

        assertThat(result).containsExactly(0, 0, 0, 0);
    }
}
