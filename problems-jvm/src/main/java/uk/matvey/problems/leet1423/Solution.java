package uk.matvey.problems.leet1423;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxScore(int[] cardPoints, int k) {
        var sum = Arrays.stream(cardPoints).sum();
        var leftSum = Arrays.stream(cardPoints, 0, cardPoints.length - k).sum();
        var max = sum - leftSum;
        for (int i = 0; i < k; i++) {
            leftSum = leftSum - cardPoints[i] + cardPoints[i + (cardPoints.length - k)];
            if (sum - leftSum > max) {
                max = sum - leftSum;
            }
        }
        return max;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};

        int result = new Solution().maxScore(cardPoints, 3);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void case2() {
        var cardPoints = new int[]{2, 2, 2};

        int result = new Solution().maxScore(cardPoints, 2);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case3() {
        var cardPoints = new int[]{9, 7, 7, 9, 7, 7, 9};

        int result = new Solution().maxScore(cardPoints, 7);

        assertThat(result).isEqualTo(55);
    }

    @Test
    void case4() {
        var cardPoints = new int[]{1, 1000, 1};

        int result = new Solution().maxScore(cardPoints, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case5() {
        var cardPoints = new int[]{1, 79, 80, 1, 1, 1, 200, 1};

        int result = new Solution().maxScore(cardPoints, 3);

        assertThat(result).isEqualTo(202);
    }
}
