package uk.matvey.play.leet1333.java1;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(restaurant -> veganFriendly == 0 || restaurant[2] == 1)
                .filter(restaurant -> restaurant[3] <= maxPrice)
                .filter(restaurant -> restaurant[4] <= maxDistance)
                .sorted((a, b) -> a[1] == b[1] ? Long.compare(b[0], a[0]) : Long.compare(b[1], a[1]))
                .map(restaurant -> restaurant[0])
                .toList();
    }
}
