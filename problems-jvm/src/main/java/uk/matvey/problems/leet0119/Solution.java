package uk.matvey.problems.leet0119;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        return nextRow(new ArrayList<>(), rowIndex);
    }

    private List<Integer> nextRow(List<Integer> previous, int rowIndex) {
        if (rowIndex < 0) {
            return previous;
        }
        var row = new ArrayList<Integer>();
        for (var i = 0; i <= previous.size(); i++) {
            row.add(i == 0 || i == previous.size() ? 1 : previous.get(i - 1) + previous.get(i));
        }
        return nextRow(row, rowIndex - 1);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        List<Integer> result = new Solution().getRow(3);

        assertThat(result).containsExactly(1, 3, 3, 1);
    }
}
