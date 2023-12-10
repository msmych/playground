package uk.matvey.play.leet1330.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{2, 3, 1, 5, 4};

        int result = new Solution().maxValueAfterReverse(nums);

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void case2() {
        var nums = new int[]{2, 4, 9, 24, 2, 1, 10};

        int result = new Solution().maxValueAfterReverse(nums);

        assertThat(result).isEqualTo(68);
    }
}
