package uk.matvey.play.leet0187.java1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        var map = new HashMap<String, Integer>();
        for (var i = 0; i <= s.length() - 10; i++) {
            var chunk = s.substring(i, i + 10);
            map.put(chunk, map.getOrDefault(chunk, 0) + 1);
        }
        return map.entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(Map.Entry::getKey)
            .toList();
    }
}
