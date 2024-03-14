package uk.matvey.problems.leet0135;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int candy(int[] ratings) {
        var candies = new int[ratings.length];
        var kids = 0;
        while (kids++ < candies.length) {
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (var i = 0; i < candies.length; i++) {
                if (candies[i] == 0) {
                    if (ratings[i] < min) {
                        min = ratings[i];
                        minIndex = i;
                    }
                }
            }
            candies[minIndex] = 1;
            if (minIndex > 0 && ratings[minIndex] > ratings[minIndex - 1] && candies[minIndex] <= candies[minIndex - 1]) {
                candies[minIndex] = candies[minIndex - 1] + 1;
            }
            if (minIndex < candies.length - 1 && ratings[minIndex] > ratings[minIndex + 1] && candies[minIndex] <= candies[minIndex + 1]) {
                candies[minIndex] = candies[minIndex + 1] + 1;
            }
        }
        return Arrays.stream(candies).sum();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var ratings = new int[]{1, 0, 2};

        int result = new Solution().candy(ratings);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        var ratings = new int[]{1, 2, 2};

        int result = new Solution().candy(ratings);

        assertThat(result).isEqualTo(4);
    }
}
