package uk.matvey.play.leet0030.java1;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private final Map<Integer, String> cache = new HashMap<>();

    private String s;
    private Map<String, Integer> wordMap;
    private int wordCount;
    private int wordLength;

    public List<Integer> findSubstring(String s, String[] words) {
        this.s = s;
        if (words.length == 0) {
            return List.of();
        }
        wordMap = Arrays.stream(words)
            .collect(Collectors.groupingBy(word -> word, Collectors.summingInt(word -> 1)));
        wordCount = words.length;
        wordLength = words[0].length();
        var starting = new ArrayList<Integer>();
        for (int i = 0; i <= s.length() - wordCount * wordLength; i++) {
            if (isConcatenation(i)) {
                starting.add(i);
            }
        }
        return starting;
    }

    private boolean isConcatenation(int i) {
        var map = new HashMap<>(wordMap);
        for (int j = i; j < i + wordCount * wordLength; j += wordLength) {
            String word;
            if (cache.containsKey(j)) {
                word = cache.get(j);
            } else {
                word = s.substring(j, j + wordLength);
                cache.put(j, word);
            }
            if (!map.containsKey(word) || map.get(word) < 1) {
                return false;
            } else {
                map.merge(word, -1, Integer::sum);
            }
        }
        return true;
    }
}
