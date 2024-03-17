package uk.matvey.problems.leet0187;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        List<String> result = new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

        assertThat(result).containsExactly("AAAAACCCCC", "CCCCCAAAAA");
    }

    @Test
    public void case2() {
        List<String> result = new Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA");

        assertThat(result).containsExactly("AAAAAAAAAA");
    }
}
