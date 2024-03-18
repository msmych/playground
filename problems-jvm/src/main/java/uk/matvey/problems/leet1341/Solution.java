package uk.matvey.problems.leet1341;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0, mat.length)
            .mapToObj(i -> soldiers(i, mat[i]))
            .sorted(Comparator.comparingInt(s -> s[1]))
            .limit(k)
            .mapToInt(s -> s[0])
            .toArray();
    }

    private int[] soldiers(int index, int[] row) {
        int count = 0;
        for (int i = 0; i < row.length && row[i] == 1; i++) {
            count++;
        }
        return new int[]{index, count};
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};

        int[] result = new Solution().kWeakestRows(mat, 3);

        assertThat(result).containsExactly(2, 0, 3);
    }

    @Test
    public void case2() {
        var mat = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};

        int[] result = new Solution().kWeakestRows(mat, 2);

        assertThat(result).containsExactly(0, 2);
    }
}
