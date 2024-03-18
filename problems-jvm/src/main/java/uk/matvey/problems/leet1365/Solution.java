package uk.matvey.problems.leet1365;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        Arrays.sort(arr);
        var map = new HashMap<Integer, Integer>();
        map.put(arr[0], 0);
        for (int i = 1, last = arr[0]; i < arr.length; i++) {
            if (arr[i] != last) {
                map.put(arr[i], i);
                last = arr[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{8, 1, 2, 2, 3};

        int[] result = new Solution().smallerNumbersThanCurrent(nums);

        assertThat(result).containsExactly(4, 0, 1, 1, 3);
    }

    @Test
    public void case2() {
        var nums = new int[]{6, 5, 4, 8};

        int[] result = new Solution().smallerNumbersThanCurrent(nums);

        assertThat(result).containsExactly(2, 1, 0, 3);
    }

    @Test
    public void case3() {
        var nums = new int[]{7, 7, 7, 7};

        int[] result = new Solution().smallerNumbersThanCurrent(nums);

        assertThat(result).containsExactly(0, 0, 0, 0);
    }
}
