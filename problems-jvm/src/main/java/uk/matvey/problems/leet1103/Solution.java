package uk.matvey.problems.leet1103;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] distributeCandies(int candies, int num_people) {
        var distribution = new int[num_people];
        int c = 1;
        int i = 0;
        while (candies >= c) {
            for (i = 0; i < num_people && candies >= c; i++) {
                distribution[i] += c;
                candies -= c++;
            }
        }
        distribution[i % num_people] += candies;
        return distribution;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int[] result = new Solution().distributeCandies(7, 4);

        assertThat(result).containsExactly(1, 2, 3, 1);
    }

    @Test
    public void case2() {
        int[] result = new Solution().distributeCandies(10, 3);

        assertThat(result).containsExactly(5, 2, 3);
    }
}
