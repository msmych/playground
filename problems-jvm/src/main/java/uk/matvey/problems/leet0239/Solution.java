package uk.matvey.problems.leet0239;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        var window = new TreeMap<Integer, Set<Integer>>();
        IntStream.range(0, k).forEach(i -> {
            window.putIfAbsent(nums[i], new HashSet<>());
            window.get(nums[i]).add(i);
        });
        int[] maxSliding = new int[nums.length - k + 1];
        maxSliding[0] = window.lastKey();
        for (int right = k; right < nums.length; right++) {
            window.putIfAbsent(nums[right], new HashSet<>());
            window.get(nums[right]).add(right);
            int left = right - k + 1;
            window.get(nums[left - 1]).remove(left - 1);
            window.remove(nums[left - 1], new HashSet<Integer>());
            maxSliding[left] = window.lastKey();
        }
        return maxSliding;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        int[] result = new Solution().maxSlidingWindow(nums, 3);

        assertThat(result).containsExactly(3, 3, 5, 5, 6, 7);
    }

    @Test
    public void case2() {
        var nums = new int[]{1};

        int[] result = new Solution().maxSlidingWindow(nums, 1);

        assertThat(result).containsExactly(1);
    }
}
