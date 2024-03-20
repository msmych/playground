package uk.matvey.problems.leet2391;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        var last = new int[3];
        for (int i = 0; i < garbage.length; i++) {
            time += garbage[i].length();
            if (garbage[i].indexOf('M') != -1) {
                last[0] = i;
            }
            if (garbage[i].indexOf('P') != -1) {
                last[1] = i;
            }
            if (garbage[i].indexOf('G') != -1) {
                last[2] = i;
            }
        }
        for (int i = 0; i < travel.length; i++) {
            if (last[0] > i) {
                time += travel[i];
            }
            if (last[1] > i) {
                time += travel[i];
            }
            if (last[2] > i) {
                time += travel[i];
            }
        }
        return time;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var garbage = new String[]{"G", "P", "GP", "GG"};
        var travel = new int[]{2, 4, 3};

        int result = new Solution().garbageCollection(garbage, travel);

        assertThat(result).isEqualTo(21);
    }

    @Test
    public void case2() {
        var garbage = new String[]{"MMM", "PGM", "GP"};
        var travel = new int[]{3, 10};

        int result = new Solution().garbageCollection(garbage, travel);

        assertThat(result).isEqualTo(37);
    }
}
