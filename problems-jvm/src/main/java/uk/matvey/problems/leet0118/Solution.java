package uk.matvey.problems.leet0118;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private int numRows;

    public List<List<Integer>> generate(int numRows) {
        this.numRows = numRows;
        return generateNext(List.of(), 0);
    }

    private List<List<Integer>> generateNext(List<Integer> previous, int i) {
        if (i == numRows) {
            return new ArrayList<>();
        }
        var triangle = new ArrayList<List<Integer>>();
        var row = new ArrayList<Integer>();
        for (var j = 0; j <= i; j++) {
            row.add(j == 0 || j == i ? 1 : previous.get(j - 1) + previous.get(j));
        }
        triangle.add(row);
        triangle.addAll(generateNext(row, i + 1));
        return triangle;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        List<List<Integer>> result = new Solution().generate(5);

        assertThat(result).containsExactly(List.of(1), List.of(1, 1), List.of(1, 2, 1), List.of(1, 3, 3, 1), List.of(1, 4, 6, 4, 1));
    }
}
