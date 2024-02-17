package uk.matvey.play.leet0049.java1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return List.copyOf(
            Arrays.stream(strs)
                .collect(Collectors.groupingBy(this::occurrences))
                .values()
        );
    }

    private Map<Character, Integer> occurrences(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }
}
