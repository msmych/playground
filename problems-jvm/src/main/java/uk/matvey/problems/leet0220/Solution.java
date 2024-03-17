package uk.matvey.problems.leet0220;

import java.util.TreeSet;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        var window = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = window.floor(nums[i] + valueDiff);
            if (floor != null && floor >= nums[i]) {
                return true;
            }
            Integer ceiling = window.ceiling(nums[i] - valueDiff);
            if (ceiling != null && ceiling <= nums[i]) {
                return true;
            }

            window.add(nums[i]);
            if (i >= indexDiff) {
                window.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 1};

        boolean result = new Solution().containsNearbyAlmostDuplicate(nums, 3, 0);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 5, 9, 1, 5, 9};

        boolean result = new Solution().containsNearbyAlmostDuplicate(nums, 2, 3);

        assertThat(result).isFalse();
    }
}
