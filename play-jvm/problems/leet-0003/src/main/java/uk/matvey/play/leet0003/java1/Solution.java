package uk.matvey.play.leet0003.java1;

import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        var charIndexes = new HashMap<Character, Integer>();
        var maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            var index = charIndexes.get(c);
            if (index != null && index > i) {
                i = index;
            }
            var length = j - i + 1;
            if (length > maxLength) {
                maxLength = length;
            }
            charIndexes.put(c, j + 1);
        }
        return maxLength;
    }
}
