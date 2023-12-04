package uk.matvey.play.leet0131.java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final Map<String, Boolean> cache = new HashMap<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        var partitions = new ArrayList<List<String>>();
        if (isPalindrome(s)) {
            partitions.add(List.of(s));
        }
        for (var i = 1; i < s.length(); i++) {
            var left = s.substring(0, i);
            if (isPalindrome(left)) {
                for (var nextPartition : partition(s.substring(i))) {
                    var partition = new ArrayList<>(nextPartition);
                    partition.add(0, left);
                    partitions.add(partition);
                }
            }
        }
        return partitions;
    }

    private boolean isPalindrome(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var isPalindrome = new StringBuffer(s).reverse().toString().equals(s);
        cache.put(s, isPalindrome);
        return isPalindrome;
    }
}
