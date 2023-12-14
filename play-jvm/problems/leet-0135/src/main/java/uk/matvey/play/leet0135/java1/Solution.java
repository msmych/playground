package uk.matvey.play.leet0135.java1;

import java.util.Arrays;

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
