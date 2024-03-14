package uk.matvey.problems.leet0034;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private int[] nums;
    private int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1, leftBorder = -1, rightBorder = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                leftBorder = nums[mid - 1] == target ? findLeftBorder(mid - 1) : mid;
                rightBorder = nums[mid + 1] == target ? findRightBorder(mid + 1) : mid;
                return new int[]{leftBorder, rightBorder};
            }
        }
        if (nums[left] == target && (left == 0 || nums[left - 1] != target)) {
            leftBorder = left;
            if (left == nums.length - 1 || nums[left + 1] != target) {
                rightBorder = left;
            }
        }
        if (nums[right] == target && (right == nums.length - 1 || nums[right + 1] != target)) {
            rightBorder = right;
            if (right == 0 || nums[right - 1] != target) {
                leftBorder = right;
            }
        }
        if (leftBorder != -1 && rightBorder != -1) {
            return new int[]{leftBorder, rightBorder};
        }
        return new int[]{-1, -1};
    }

    private int findLeftBorder(int right) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int findRightBorder(int left) {
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{5, 7, 7, 8, 8, 10};

        int[] result = new Solution().searchRange(nums, 8);

        assertThat(result).containsExactly(3, 4);
    }

    @Test
    public void case2() {
        var nums = new int[]{5, 7, 7, 8, 8, 10};

        int[] result = new Solution().searchRange(nums, 6);

        assertThat(result).containsExactly(-1, -1);
    }
}
