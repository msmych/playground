package uk.matvey.problems.leet1389;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        var target = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            target.add(index[i], nums[i]);
        }
        return target.stream().mapToInt(n -> n).toArray();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var nums = new int[]{0, 1, 2, 3, 4};
        var index = new int[]{0, 1, 2, 2, 1};

        int[] result = new Solution().createTargetArray(nums, index);

        assertThat(result).containsExactly(0, 4, 1, 3, 2);
    }

    @Test
    void case2() {
        var nums = new int[]{1, 2, 3, 4, 0};
        var index = new int[]{0, 1, 2, 3, 0};

        int[] result = new Solution().createTargetArray(nums, index);

        assertThat(result).containsExactly(0, 1, 2, 3, 4);
    }

    @Test
    void case3() {
        var nums = new int[]{1};
        var index = new int[]{0};

        int[] result = new Solution().createTargetArray(nums, index);

        assertThat(result).containsExactly(1);
    }
}
