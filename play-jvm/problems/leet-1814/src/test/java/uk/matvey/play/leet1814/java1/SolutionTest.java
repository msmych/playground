package uk.matvey.play.leet1814.java1;

import org.junit.jupiter.api.Test;
import uk.matvey.play.utils.TestCaseReader;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{42, 11, 1, 97};

        int result = new Solution().countNicePairs(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var nums = new int[]{13, 10, 35, 24, 76};

        int result = new Solution().countNicePairs(nums);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        var nums = new TestCaseReader("case3").parseIntArr("nums.txt");

        int result = new Solution().countNicePairs(nums);

        assertThat(result).isEqualTo(92974217);
    }
}
