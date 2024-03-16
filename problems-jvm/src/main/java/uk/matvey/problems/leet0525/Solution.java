package uk.matvey.problems.leet0525;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int findMaxLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var max = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            map.putIfAbsent(count, i);
            int len = i - map.get(count);
            if (len > max) {
                max = len;
            }
            if (count == 0 && i + 1 > max) {
                max = i + 1;
            }
        }
        return max;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{0, 1};

        int result = new Solution().findMaxLength(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var nums = new int[]{0, 1, 0};

        int result = new Solution().findMaxLength(nums);

        assertThat(result).isEqualTo(2);
    }
}