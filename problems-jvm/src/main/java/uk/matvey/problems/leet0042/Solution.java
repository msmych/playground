package uk.matvey.problems.leet0042;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int water = 0;
        var levels = new Stack<int[]>();
        levels.push(new int[]{0, height[0]});
        int lastLevel = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > lastLevel && !levels.isEmpty()) {
                int[] level;
                while (!levels.isEmpty()) {
                    level = levels.peek();
                    water += (i - level[0] - 1) * (Math.min(height[i], level[1]) - lastLevel);
                    if (height[i] > level[1]) {
                        levels.pop();
                        lastLevel = level[1];
                    } else {
                        levels.push(new int[]{i, height[i]});
                        break;
                    }
                }
                if (levels.isEmpty()) {
                    levels.push(new int[]{i, height[i]});
                }
            } else {
                levels.push(new int[]{i, height[i]});
                lastLevel = height[i];
            }
        }
        return water;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        var result = new Solution().trap(height);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case2() {
        var height = new int[]{4, 2, 0, 3, 2, 5};

        var result = new Solution().trap(height);

        assertThat(result).isEqualTo(9);
    }
}
