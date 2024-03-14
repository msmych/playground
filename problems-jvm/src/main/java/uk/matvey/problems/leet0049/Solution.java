package uk.matvey.problems.leet0049;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        var strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        var result = new Solution().groupAnagrams(strs);

        assertThat(result).hasSize(3);
    }
}
