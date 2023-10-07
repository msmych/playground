package uk.matvey.play.leet0010.java1;

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        var firstMatch = false;
        if (!s.isEmpty()) {
            var cs = s.charAt(0);
            var cp = p.charAt(0);
            firstMatch = cs == cp || cp == '.';
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
