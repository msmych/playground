package uk.matvey.problems.leet1431;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        var max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies)
            .mapToObj(candy -> candy + extraCandies >= max)
            .toList();
    }
}

class SolutionTest {

    @Test
    void case1() {
        var candies = new int[]{2, 3, 5, 1, 3};

        List<Boolean> result = new Solution().kidsWithCandies(candies, 3);

        assertThat(result).containsExactly(true, true, true, false, true);
    }

    @Test
    void case2() {
        var candies = new int[]{4, 2, 1, 1, 2};

        List<Boolean> result = new Solution().kidsWithCandies(candies, 1);

        assertThat(result).containsExactly(true, false, false, false, false);
    }

    @Test
    void case3() {
        var candies = new int[]{12, 1, 12};

        List<Boolean> result = new Solution().kidsWithCandies(candies, 10);

        assertThat(result).containsExactly(true, false, true);
    }
}
