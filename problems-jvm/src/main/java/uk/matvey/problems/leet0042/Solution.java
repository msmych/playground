package uk.matvey.problems.leet0042;

import org.junit.jupiter.api.Test;
import uk.matvey.problems.leet.TestCaseReader;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean hasOne = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                hasOne = true;
            } else if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = 1;
            }
        }
        if (!hasOne) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            int n = Math.abs(nums[i]);
            if (n == len) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[n] = -Math.abs(nums[n]);
            }
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        if (nums[0] > 0) {
            return len;
        }
        return len + 1;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var nums = new int[]{1, 2, 0};

        int result = new Solution().firstMissingPositive(nums);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        var nums = new int[]{3, 4, -1, 1};

        int result = new Solution().firstMissingPositive(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        var nums = new int[]{7, 8, 9, 11, 12};

        int result = new Solution().firstMissingPositive(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        var nums = new TestCaseReader("leet0042/case4").parseIntArr("nums.txt");

        int result = new Solution().firstMissingPositive(nums);

        assertThat(result).isEqualTo(100001);
    }
}
