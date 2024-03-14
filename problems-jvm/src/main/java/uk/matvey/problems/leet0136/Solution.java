package uk.matvey.problems.leet0136;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int singleNumber(int[] nums) {
        return 2 * Arrays.stream(nums).distinct().sum() - Arrays.stream(nums).sum();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().singleNumber(new int[]{2, 2, 1})).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().singleNumber(new int[]{4, 1, 2, 1, 2})).isEqualTo(4);
    }
}
