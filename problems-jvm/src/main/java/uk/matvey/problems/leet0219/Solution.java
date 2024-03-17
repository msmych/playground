package uk.matvey.problems.leet0219;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var window = IntStream.rangeClosed(0, k).mapToObj(i -> nums[i])
            .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)));
        if (window.values().stream().anyMatch(n -> n > 1)) {
            return true;
        }
        for (int j = k + 1; j < nums.length; j++) {
            window.merge(nums[j - k - 1], -1, Integer::sum);
            window.merge(nums[j], 1, Integer::sum);
            if (window.get(nums[j]) > 1) {
                return true;
            }
        }
        return false;
    }
}
class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 1};

        boolean result = new Solution().containsNearbyDuplicate(nums, 3);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 0, 1, 1};

        boolean result = new Solution().containsNearbyDuplicate(nums, 1);

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        var nums = new int[]{1, 2, 3, 1, 2, 3};

        boolean result = new Solution().containsNearbyDuplicate(nums, 2);

        assertThat(result).isFalse();
    }
}
