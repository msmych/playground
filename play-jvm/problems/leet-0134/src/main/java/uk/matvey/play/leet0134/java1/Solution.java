package uk.matvey.play.leet0134.java1;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (var i = 0; i < gas.length; i++) {
            var canFinish = true;
            var g = 0;
            for (var j = 0; j < gas.length; j++) {
                g += gas[(i + j) % gas.length];
                g -= cost[(i + j) % cost.length];
                if (g < 0) {
                    canFinish = false;
                    break;
                }
            }
            if (canFinish) {
                return i;
            }
        }
        return -1;
    }
}
