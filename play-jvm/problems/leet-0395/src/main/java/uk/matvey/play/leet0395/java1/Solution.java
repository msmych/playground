package uk.matvey.play.leet0395.java1;

import java.util.HashSet;

public class Solution {
    public int longestSubstring(String s, int k) {
        HashSet<Character> seen = new HashSet<>();
        s.chars().forEach(c -> seen.add((char) c));
        int max = 0;
        for (int currUnique = 1; currUnique < seen.size(); currUnique++) {
            int[] occurrences = new int[26];
            int left = 0;
            int right = 0;
            int unique = 0;
            int count = 0;
            while (right < s.length()) {
                if (unique <= currUnique) {
                    int i = s.charAt(right) - 'a';
                    if (occurrences[i] == 0) {
                        unique++;
                    }
                    occurrences[i]++;
                    if (occurrences[i] == k) {
                        count++;
                    }
                    right++;
                } else {
                    int i = occurrences[left] - 'a';
                    if (occurrences[i] == k) {
                        count--;
                    }
                    occurrences[i]--;
                    if (occurrences[i] == 0) {
                        unique--;
                    }
                    left++;
                }
                if (unique == currUnique && unique == count && right - left > max) {
                    max = right - left;
                }
            }
        }
        return max;
    }
}
