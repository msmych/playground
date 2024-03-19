package uk.matvey.problems.leet1436;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String destCity(List<List<String>> paths) {
        return paths.stream()
            .map(path -> path.get(1))
            .filter(destination -> paths.stream()
                .map(List::getFirst)
                .noneMatch(destination::equals))
            .findAny()
            .orElseThrow();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var paths = List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"));

        String result = new Solution().destCity(paths);

        assertThat(result).isEqualTo("Sao Paulo");
    }

    @Test
    public void case2() {
        var paths = List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A"));

        String result = new Solution().destCity(paths);

        assertThat(result).isEqualTo("A");
    }

    @Test
    public void case3() {
        var paths = List.of(List.of("A", "Z"));

        String result = new Solution().destCity(paths);

        assertThat(result).isEqualTo("Z");
    }
}
