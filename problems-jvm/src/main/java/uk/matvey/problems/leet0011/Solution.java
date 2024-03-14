package uk.matvey.problems.leet0011;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxArea(int[] height) {
        var maxArea = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (var j = i + 1; j < height.length; j++) {
                var area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = new Solution().maxArea(height);

        assertThat(result).isEqualTo(49);
    }
}
