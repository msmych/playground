package uk.matvey.problems.leet0451;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public String frequencySort(String s) {
        return s.chars()
            .mapToObj(Character::toString)
            .collect(Collectors.groupingBy(c -> c))
            .values()
            .stream()
            .sorted(Comparator.comparing(List::size, Comparator.reverseOrder()))
            .map(list -> String.join("", list))
            .collect(Collectors.joining());
    }
}

class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().frequencySort("tree");

        assertThat(result).isEqualTo("eert");
    }

    @Test
    public void case2() {
        String result = new Solution().frequencySort("cccaaa");

        assertThat(result).isEqualTo("aaaccc");
    }

    @Test
    public void case3() {
        String result = new Solution().frequencySort("Aabb");

        assertThat(result).isEqualTo("bbaA");
    }
}
