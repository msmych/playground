package uk.matvey.problems.leet0368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        Arrays.sort(nums);
        var arr = new int[nums.length];
        var parent = new int[nums.length];
        Arrays.fill(parent, -1);
        arr[0] = 1;
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (arr[j] + 1 > arr[i]) {
                        arr[i] = arr[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        var subset = new ArrayList<Integer>();
        for (int i = maxIndex; i >= 0; i = parent[i]) {
            subset.addFirst(nums[i]);
        }
        return subset;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3};

        List<Integer> result = new Solution().largestDivisibleSubset(nums);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 2, 4, 8};

        List<Integer> result = new Solution().largestDivisibleSubset(nums);

        assertThat(result).containsExactly(1, 2, 4, 8);
    }

    @Test
    public void case3() {
        var nums = new int[]{2, 3, 8, 9, 27};

        List<Integer> result = new Solution().largestDivisibleSubset(nums);

        assertThat(result).containsExactly(3, 9, 27);
    }
}
