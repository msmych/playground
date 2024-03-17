package uk.matvey.problems.leet1291;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static final String DIGITS = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        return IntStream.rangeClosed(String.valueOf(low).length(), String.valueOf(high).length())
            .mapToObj(n -> IntStream.rangeClosed(0, DIGITS.length() - n)
                .mapToObj(i -> DIGITS.substring(i, i + n))
                .map(Integer::parseInt)
                .filter(i -> i >= low)
                .filter(i -> i <= high)
                .collect(Collectors.toList()))
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}

class SolutionTest {

    @Test
    public void case1() {
        List<Integer> result = new Solution().sequentialDigits(100, 300);

        assertThat(result).containsExactly(123, 234);
    }

    @Test
    public void case2() {
        List<Integer> result = new Solution().sequentialDigits(1000, 13000);

        assertThat(result).containsExactly(1234, 2345, 3456, 4567, 5678, 6789, 12345);
    }
}
