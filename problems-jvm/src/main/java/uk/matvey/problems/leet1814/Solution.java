package uk.matvey.problems.leet1814;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        var goods = Arrays.stream(nums)
            .mapToObj(i -> i - Integer.parseInt(new StringBuffer(Integer.toString(i)).reverse().toString()))
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        return (int) goods.values().stream().mapToLong(i -> i * (i - 1) / 2 % MOD).sum() % MOD;
    }
}

class SolutionTest {

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
        var nums = new TestCaseReader("leet1814/case3").parseIntArr("nums.txt");

        int result = new Solution().countNicePairs(nums);

        assertThat(result).isEqualTo(92974217);
    }
}
