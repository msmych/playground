package uk.matvey.play.leet0128.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{100, 4, 200, 1, 3, 2};

        int result = new Solution().longestConsecutive(nums);

        assertThat(result).isEqualTo(4);
    }
}
