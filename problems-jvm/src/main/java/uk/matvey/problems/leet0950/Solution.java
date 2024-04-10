package uk.matvey.problems.leet0950;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        var ordering = new int[n];
        Arrays.sort(deck);
        int di = 0;
        int oi = 0;
        boolean skip = false;
        while (di < n) {
            if (ordering[oi] == 0) {
                if (!skip) {
                    ordering[oi] = deck[di];
                    di++;
                }
                skip = !skip;
            }
            oi = (oi + 1) % n;
        }
        return ordering;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var deck = new int[]{17, 13, 11, 2, 3, 5, 7};

        var result = new Solution().deckRevealedIncreasing(deck);

        assertThat(result).containsExactly(2, 13, 3, 11, 5, 17, 7);
    }

    @Test
    void case2() {
        var deck = new int[]{1, 1000};

        var result = new Solution().deckRevealedIncreasing(deck);

        assertThat(result).containsExactly(1, 1000);
    }

    @Test
    void case3() {
        var deck = new int[]{1, 2, 3, 4};

        var result = new Solution().deckRevealedIncreasing(deck);

        assertThat(result).containsExactly(1, 3, 2, 4);
    }

    @Test
    void case4() {
        var deck = new int[]{1, 2, 3, 4, 5};

        var result = new Solution().deckRevealedIncreasing(deck);

        assertThat(result).containsExactly(1, 5, 2, 4, 3);
    }
}
