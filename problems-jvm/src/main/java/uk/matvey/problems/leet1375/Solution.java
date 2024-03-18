package uk.matvey.problems.leet1375;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numTimesAllBlue(int[] light) {
        int num = light[0] == 1 ? 1 : 0;
        var bulbs = new HashSet<Integer>();
        bulbs.add(light[0]);
        int max = light[0];
        for (int i = 1; i < light.length; i++) {
            bulbs.add(light[i]);
            if (light[i] > max) {
                max = light[i];
            }
            if (IntStream.range(1, max).allMatch(bulbs::contains)) {
                num++;
            }
        }
        return num;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var light = new int[]{2, 1, 3, 5, 4};

        int result = new Solution().numTimesAllBlue(light);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var light = new int[]{3, 2, 4, 1, 5};

        int result = new Solution().numTimesAllBlue(light);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case3() {
        var light = new int[]{4, 1, 2, 3};

        int result = new Solution().numTimesAllBlue(light);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        var light = new int[]{2, 1, 4, 3, 6, 5};

        int result = new Solution().numTimesAllBlue(light);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case5() {
        var light = new int[]{1, 2, 3, 4, 5, 6};

        int result = new Solution().numTimesAllBlue(light);

        assertThat(result).isEqualTo(6);
    }
}
