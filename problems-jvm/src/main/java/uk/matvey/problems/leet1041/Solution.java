package uk.matvey.problems.leet1041;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private int x;
    private int y;
    private int d;

    public boolean isRobotBounded(String instructions) {
        if (!instructions.contains("L") && !instructions.contains("R")) {
            return false;
        }
        for (var j = 0; j < instructions.length(); j++) {
            move(instructions.charAt(j));
        }
        return d != 0 || x == 0 && y == 0;
    }

    private void move(char instruction) {
        switch (instruction) {
            case 'L':
                d = d == 0 ? 3 : d - 1;
                break;
            case 'R':
                d = (d + 1) % 4;
                break;
            case 'G':
                go();
        }
    }

    private void go() {
        switch (d) {
            case 0:
                y++;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
        }
    }
}

class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isRobotBounded("GGLLGG");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isRobotBounded("GG");

        assertThat(result).isFalse();
    }

    @Test
    public void case3() {
        boolean result = new Solution().isRobotBounded("GL");

        assertThat(result).isTrue();
    }
}
