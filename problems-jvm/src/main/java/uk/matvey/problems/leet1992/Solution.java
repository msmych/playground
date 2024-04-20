package uk.matvey.problems.leet1992;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private record Position(
        int i,
        int j
    ) {
    }

    public int[][] findFarmland(int[][] land) {
        var unvisited = IntStream.range(0, land.length)
            .boxed()
            .flatMap(i ->
                IntStream.range(0, land[i].length)
                    .filter(j -> land[i][j] == 1)
                    .mapToObj(j -> new Position(i, j))
            )
            .collect(Collectors.toSet());
        var result = new ArrayList<int[]>();
        while (!unvisited.isEmpty()) {
            var position = unvisited.iterator().next();
            int i1 = position.i;
            while (i1 > 0 && land[i1 - 1][position.j] == 1) {
                i1--;
            }
            int j1 = position.j;
            while (j1 > 0 && land[position.i][j1 - 1] == 1) {
                j1--;
            }
            int i2 = position.i;
            while (i2 < land.length - 1 && land[i2 + 1][position.j] == 1) {
                i2++;
            }
            int j2 = position.j;
            while (j2 < land[i1].length - 1 && land[position.i][j2 + 1] == 1) {
                j2++;
            }
            result.add(new int[]{i1, j1, i2, j2});
            for (int i = i1; i <= i2; i++) {
                for (int j = j1; j <= j2; j++) {
                    unvisited.remove(new Position(i, j));
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}

class SolutionTest {

    @Test
    void case1() {
        var land = new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}};

        var result = new Solution().findFarmland(land);

        assertThat(result).hasDimensions(2, 4);
        assertThat(result[0]).containsExactly(0, 0, 0, 0);
        assertThat(result[1]).containsExactly(1, 1, 2, 2);
    }

    @Test
    void case2() {
        var land = new int[][]{{1, 1}, {1, 1}};

        var result = new Solution().findFarmland(land);

        assertThat(result).hasDimensions(1, 4);
        assertThat(result[0]).containsExactly(0, 0, 1, 1);
    }

    @Test
    void case3() {
        var land = new int[][]{{0}};

        var result = new Solution().findFarmland(land);

        assertThat(result).isEmpty();
    }
}
