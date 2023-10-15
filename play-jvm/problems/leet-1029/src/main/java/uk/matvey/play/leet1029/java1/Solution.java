package uk.matvey.play.leet1029.java1;

import java.util.Arrays;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        var min = 0;
        var refund = new int[costs.length];
        for (var i = 0; i < costs.length; i++) {
            refund[i] = costs[i][1] - costs[i][0];
            min += costs[i][0];
        }
        Arrays.sort(refund);
        for (var i = 0; i < costs.length / 2; i++) {
            min += refund[i];
        }
        return min;
    }
}
