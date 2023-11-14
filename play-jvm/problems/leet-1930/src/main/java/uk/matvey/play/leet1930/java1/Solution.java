package uk.matvey.play.leet1930.java1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        var indexes = new HashMap<Character, TreeSet<Integer>>();
        IntStream.range(0, s.length()).forEach(i -> {
            char c = s.charAt(i);
            indexes.putIfAbsent(c, new TreeSet<>());
            indexes.get(c).add(i);
        });
        var palindromes = new HashSet<String>();
        for (var mid : indexes.entrySet()) {
            for (int i : mid.getValue()) {
                indexes.entrySet().stream().filter(e -> e.getValue().size() > 1).forEach(outer -> {
                    char c = outer.getKey();
                    var outerIndexes = outer.getValue();
                    String palindrome = String.valueOf(new char[]{c, mid.getKey(), c});
                    if (palindromes.contains(palindrome)) {
                        return;
                    }
                    if (outerIndexes.floor(i - 1) != null && outerIndexes.ceiling(i + 1) != null) {
                        palindromes.add(palindrome);
                    }
                });
            }
        }
        return palindromes.size();
    }
}
