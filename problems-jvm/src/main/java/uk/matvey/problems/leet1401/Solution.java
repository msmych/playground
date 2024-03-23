package uk.matvey.problems.leet1401;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private int radius, cx, cy;

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        this.radius = radius;
        this.cx = x_center;
        this.cy = y_center;
        return pointIsInCircle(x1, y1) || pointIsInCircle(x2, y2) || pointIsInCircle(x1, y2) || pointIsInCircle(x2, y1) ||
            cy >= y1 && cy <= y2 && (Math.abs(x1 - cx) <= radius || Math.abs(x2 - cx) <= radius) ||
            cx >= x1 && cx <= x2 && (Math.abs(y1 - cy) <= radius || Math.abs(y2 - cy) <= radius) ||
            cx >= x1 && cx <= x2 && cy >= y1 && cy <= y2;
    }

    private boolean pointIsInCircle(int x, int y) {
        return Math.sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy)) <= radius;
    }
}

class SolutionTest {

    @Test
    void case1() {
        final var result = new Solution().checkOverlap(1, 0, 0, 1, -1, 3, 1);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        final var result = new Solution().checkOverlap(1, 0, 0, -1, 0, 0, 1);

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        final var result = new Solution().checkOverlap(1, 1, 1, -3, -3, 3, 3);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        final var result = new Solution().checkOverlap(1, 1, 1, 1, -3, 2, -1);

        assertThat(result).isFalse();
    }
}