package uk.matvey.problems.leet1395;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numTeams(int[] rating) {
        int teams = 0;
        for (int i = 0; i < rating.length - 2; i++) {
            for (int j = i + 1; j < rating.length - 1; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] < rating[j] && rating[j] < rating[k] ||
                        rating[i] > rating[j] && rating[j] > rating[k]) {
                        teams++;
                    }
                }
            }
        }
        return teams;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var rating = new int[]{2, 5, 3, 4, 1};

        assertThat(new Solution().numTeams(rating)).isEqualTo(3);
    }

    @Test
    void case2() {
        var rating = new int[]{2, 1, 3};

        assertThat(new Solution().numTeams(rating)).isEqualTo(0);
    }

    @Test
    void case3() {
        var rating = new int[]{1, 2, 3, 4};

        assertThat(new Solution().numTeams(rating)).isEqualTo(4);
    }
}
