package uk.matvey.problems.leet0131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        List<List<String>> result = new Solution().partition("aab");

        assertThat(result).containsExactlyInAnyOrder(List.of("aa", "b"), List.of("a", "a", "b"));
    }
}
