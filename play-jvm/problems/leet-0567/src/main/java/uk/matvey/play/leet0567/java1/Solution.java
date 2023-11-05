package uk.matvey.play.leet0567.java1;

import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        var map1 = occurrences(s1);
        var map2 = occurrences(s2.substring(0, s1.length()));
        var balance = map1.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> map2.getOrDefault(e.getKey(), 0) - e.getValue()));
        if (balance.values().stream().allMatch(n -> n >= 0)) {
            return true;
        }
        for (var i = 0; i + s1.length() < s2.length(); i++) {
            balance.computeIfPresent(s2.charAt(i), (k, v) -> v - 1);
            balance.computeIfPresent(s2.charAt(i + s1.length()), (k, v) -> v + 1);
            if (balance.values().stream().allMatch(n -> n >= 0)) {
                return true;
            }
        }
        return false;
    }

    private Map<Character, Integer> occurrences(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }
}
