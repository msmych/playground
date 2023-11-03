package uk.matvey.play.leet0076.java1;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        var minWindow = "";
        var target = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        var window = new HashMap<Character, Integer>();
        int i = 0, j = 0;
        for (; j < t.length(); j++) {
            var c = s.charAt(j);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }
        while (i <= s.length() - t.length() && j <= s.length() && i < j) {
            boolean valid = true;
            for (var entry : target.entrySet()) {
                if (!window.containsKey(entry.getKey()) || window.get(entry.getKey()) < entry.getValue()) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                if (minWindow.isEmpty() || j - i < minWindow.length()) {
                    minWindow = s.substring(i, j);
                }
                var c = s.charAt(i++);
                if (window.get(c) > 0) {
                    window.put(c, window.get(c) - 1);
                }
            } else if (j < s.length()) {
                var c = s.charAt(j++);
                window.put(c, window.getOrDefault(c, 0) + 1);
            } else {
                break;
            }
        }
        return minWindow;
    }
}
