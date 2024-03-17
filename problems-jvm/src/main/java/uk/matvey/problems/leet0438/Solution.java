package uk.matvey.problems.leet0438;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.isEmpty() || p.length() > s.length()) {
            return List.of();
        }
        var pmap = occurrences(p);
        var smap = occurrences(s.substring(0, p.length()));
        var anagrams = new ArrayList<Integer>();
        if (smap.equals(pmap)) {
            anagrams.add(0);
        }
        for (var i = 0; i + p.length() < s.length(); i++) {
            if (smap.get(s.charAt(i)) == 1) {
                smap.remove(s.charAt(i));
            } else {
                smap.merge(s.charAt(i), -1, Integer::sum);
            }
            smap.merge(s.charAt(i + p.length()), 1, Integer::sum);
            if (smap.equals(pmap)) {
                anagrams.add(i + 1);
            }
        }
        return anagrams;
    }

    private Map<Character, Integer> occurrences(String s) {
        return s.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
    }
}

class SolutionTest {

    @Test
    public void case1() {
        List<Integer> result = new Solution().findAnagrams("cbaebabacd", "abc");

        assertThat(result).containsExactly(0, 6);
    }

    @Test
    public void case2() {
        List<Integer> result = new Solution().findAnagrams("abab", "ab");

        assertThat(result).containsExactly(0, 1, 2);
    }
}
