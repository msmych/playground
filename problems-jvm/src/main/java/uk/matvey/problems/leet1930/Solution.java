package uk.matvey.problems.leet1930;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

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
                    var palindrome = String.valueOf(new char[]{c, mid.getKey(), c});
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

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().countPalindromicSubsequence("aabca");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().countPalindromicSubsequence("adc");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().countPalindromicSubsequence("bbcbaba");

        assertThat(result).isEqualTo(4);
    }
}
