package uk.matvey.play.leet2433.java1;

public class Solution {
    public int[] findArray(int[] pref) {
        var arr = new int[pref.length];
        int last = 0;
        for (int i = 0; i < pref.length; i++) {
            arr[i] = last ^ pref[i];
            last = pref[i];
        }
        return arr;
    }
}
