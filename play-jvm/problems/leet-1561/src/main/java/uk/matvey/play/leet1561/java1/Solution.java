package uk.matvey.play.leet1561.java1;

import java.util.Arrays;

public class Solution {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        var candies = 0;
        for (int i = piles.length - 2, b = 0; i > b; i -= 2, b++) {
            candies += piles[i];
        }
        return candies;
    }
}
