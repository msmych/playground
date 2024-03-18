package uk.matvey.problems.leet1366;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String rankTeams(String[] votes) {
        var sb = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            var set = votes[0].chars().mapToObj(c -> (char) c)
                .filter(c -> !sb.toString().contains(c.toString()))
                .collect(Collectors.toSet());
            for (int j = 0; j < votes[0].length(); j++) {
                int index = j;
                var map = Arrays.stream(votes)
                    .map(vote -> vote.charAt(index))
                    .filter(set::contains)
                    .collect(Collectors.groupingBy(c -> c, Collectors.summingInt(c -> 1)));
                var max = map.values().stream().mapToInt(v -> v).max();
                if (max.isPresent()) {
                    var next = map.entrySet().stream()
                        .filter(e -> e.getValue() == max.getAsInt())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toSet());
                    if (next.size() == 1) {
                        sb.append(next.iterator().next());
                        break;
                    }
                    set = next;
                }
            }
            if (sb.length() == i) {
                sb.append(set.stream().min(Comparator.naturalOrder()).get());
            }
        }
        return sb.toString();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("ACB");
    }

    @Test
    public void case2() {
        var votes = new String[]{"WXYZ", "XYZW"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("XWYZ");
    }

    @Test
    public void case3() {
        var votes = new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("ZMNAGUEDSJYLBOPHRQICWFXTVK");
    }

    @Test
    public void case4() {
        var votes = new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("ABC");
    }

    @Test
    public void case5() {
        var votes = new String[]{"M", "M", "M", "M"};

        final var result = new Solution().rankTeams(votes);

        assertThat(result).isEqualTo("M");
    }
}
