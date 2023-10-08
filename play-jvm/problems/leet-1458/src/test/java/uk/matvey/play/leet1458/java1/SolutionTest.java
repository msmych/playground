package uk.matvey.play.leet1458.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
