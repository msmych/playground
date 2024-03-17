package uk.matvey.problems.leet0458;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int minPigs = 0;
        for (int rounds = minutesToTest / minutesToDie; Math.pow(rounds + 1, minPigs) < buckets; minPigs++) {
        }
        return minPigs;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().poorPigs(4, 15, 15);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        int result = new Solution().poorPigs(4, 15, 30);

        assertThat(result).isEqualTo(2);
    }
}
