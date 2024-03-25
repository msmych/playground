package uk.matvey.problems.leet1409;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] processQueries(int[] queries, int m) {
        var permutations = IntStream.rangeClosed(1, m).boxed().collect(Collectors.toList());
        for (int i = 0; i < queries.length; i++) {
            var index = permutations.indexOf(queries[i]);
            permutations.remove(index);
            permutations.addFirst(queries[i]);
            queries[i] = index;
        }
        return queries;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var queries = new int[]{3, 1, 2, 1};

        var result = new Solution().processQueries(queries, 5);

        assertThat(result).containsExactly(2, 1, 2, 1);
    }

    @Test
    void case2() {
        var queries = new int[]{4, 1, 2, 2};

        var result = new Solution().processQueries(queries, 4);

        assertThat(result).containsExactly(3, 1, 2, 0);
    }

    @Test
    void case3() {
        var queries = new int[]{7, 5, 5, 8, 3};

        var result = new Solution().processQueries(queries, 8);

        assertThat(result).containsExactly(6, 5, 0, 7, 5);
    }
}
