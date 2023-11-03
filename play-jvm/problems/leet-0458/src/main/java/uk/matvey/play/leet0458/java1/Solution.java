package uk.matvey.play.leet0458.java1;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int minPigs = 0;
        for (int rounds = minutesToTest / minutesToDie; Math.pow(rounds + 1, minPigs) < buckets; minPigs++) {
        }
        return minPigs;
    }
}
