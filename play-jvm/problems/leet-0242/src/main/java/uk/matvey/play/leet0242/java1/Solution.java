package uk.matvey.play.leet0242.java1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return getMap(s).equals(getMap(t));
    }

    private Map<Character, Integer> getMap(String s) {
        var map = new HashMap<Character, Integer>();
        for (var c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
