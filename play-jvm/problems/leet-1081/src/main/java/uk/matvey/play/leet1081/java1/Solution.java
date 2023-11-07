package uk.matvey.play.leet1081.java1;

public class Solution {
    public String smallestSubsequence(String text) {
        if (text.isEmpty()) {
            return "";
        }
        var count = new int[26];
        text.chars().map(c -> c - 'a').forEach(c -> count[c]++);
        var min = 0;
        for (var i = 0; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(min)) {
                min = i;
            }
            if (--count[text.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return text.charAt(min) + smallestSubsequence(text.substring(min + 1).replaceAll("" + text.charAt(min), ""));
    }
}
