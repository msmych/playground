package uk.matvey.problems.leet0238;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        var products = new int[nums.length];
        products[0] = 1;
        for (int i = 1; i < products.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        var product = 1;
        for (int i = products.length - 2; i >= 0; i--) {
            products[i] *= nums[i + 1] * product;
            product *= nums[i + 1];
        }
        return products;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 4};

        int[] result = new Solution().productExceptSelf(nums);

        assertThat(result).containsExactly(24, 12, 8, 6);
    }
}