package uk.matvey.play.leet1347.java1;

public class Solution {
    public int minSteps(String s, String t) {
        int[] smap = occurrences(s);
        int[] tmap = occurrences(t);
        int difference = 0;
        for (int i = 0; i < 26; i++) {
            difference += Math.abs(smap[i] - tmap[i]);
        }
        return difference % 2 == 0
                ? difference / 2
                : difference / 2 + 1;
    }

    private int[] occurrences(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}
