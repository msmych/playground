package uk.matvey.play.leet2391.java1;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        var last = new int[3];
        for (int i = 0; i < garbage.length; i++) {
            time += garbage[i].length();
            if (garbage[i].indexOf('M') != -1) {
                last[0] = i;
            }
            if (garbage[i].indexOf('P') != -1) {
                last[1] = i;
            }
            if (garbage[i].indexOf('G') != -1) {
                last[2] = i;
            }
        }
        for (int i = 0; i < travel.length; i++) {
            if (last[0] > i) {
                time += travel[i];
            }
            if (last[1] > i) {
                time += travel[i];
            }
            if (last[2] > i) {
                time += travel[i];
            }
        }
        return time;
    }
}
