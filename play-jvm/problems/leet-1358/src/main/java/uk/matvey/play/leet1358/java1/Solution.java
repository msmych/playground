package uk.matvey.play.leet1358.java1;

import java.util.Arrays;

public class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] letters = new int[]{-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] = i;
            count += 1 + Arrays.stream(letters).min().getAsInt();
        }
        return count;
    }
}
