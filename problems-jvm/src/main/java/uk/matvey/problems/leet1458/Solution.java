package uk.matvey.problems.leet1458;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int max1 = nums1[0];
        int min1 = nums1[0];
        int max2 = nums2[0];
        int min2 = nums2[0];
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] > max1) {
                max1 = nums1[i];
            }
            if (nums1[i] < min1) {
                min1 = nums1[i];
            }
        }
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] > max1) {
                max2 = nums2[i];
            }
            if (nums2[i] < min2) {
                min2 = nums2[i];
            }
        }
        if (max1 < 0 && min2 > 0) {
            return max1 * min2;
        }
        if (min1 > 0 && max2 < 0) {
            return min1 * max2;
        }
        var dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int use = nums1[i] * nums2[j] + dp[i + 1][j + 1];
                dp[i][j] = Math.max(use, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }
        return dp[0][0];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums1 = new int[]{2, 1, -2, 5};
        var nums2 = new int[]{3, 0, -6};

        int result = new Solution().maxDotProduct(nums1, nums2);

        assertThat(result).isEqualTo(18);
    }

    @Test
    public void case2() {
        var nums1 = new int[]{3, -2};
        var nums2 = new int[]{2, -6, 7};

        int result = new Solution().maxDotProduct(nums1, nums2);

        assertThat(result).isEqualTo(21);
    }

    @Test
    public void case3() {
        var nums1 = new int[]{-1, -1};
        var nums2 = new int[]{1, 1};

        int result = new Solution().maxDotProduct(nums1, nums2);

        assertThat(result).isEqualTo(-1);
    }
}
