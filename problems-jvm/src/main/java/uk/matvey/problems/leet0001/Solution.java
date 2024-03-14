package uk.matvey.problems.leet0001;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[]{map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{2, 7, 11, 15};

        int[] result = new Solution().twoSum(nums, 9);

        assertThat(result).containsExactly(0, 1);
    }
}
