package uk.matvey.play.leet1503.java1;

public class Solution {

    public int getLastMoment(int n, int[] left, int[] right) {
        int minDistance = n;
        for (int l : left) {
            if (n - l < minDistance) {
                minDistance = n - l;
            }
        }
        for (int r : right) {
            if (r < minDistance) {
                minDistance = r;
            }
        }
        return n - minDistance;
    }
}
