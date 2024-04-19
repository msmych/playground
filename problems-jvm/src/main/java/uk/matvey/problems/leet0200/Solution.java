package uk.matvey.problems.leet0200;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private record Point(
        int x,
        int y
    ) {
    }

    private final Set<Point> visited = new HashSet<>();

    private char[][] grid;
    private int numIslands = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        this.grid = grid;
        for (var y = 0; y < grid.length; y++) {
            for (var x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1' && !visited.contains(new Point(x, y))) {
                    numIslands++;
                    explore(x, y);
                }
            }
        }
        return numIslands;
    }

    private void explore(int x, int y) {
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
            return;
        }
        var point = new Point(x, y);
        if (visited.contains(point)) {
            return;
        }
        visited.add(point);
        if (grid[y][x] == '0') {
            return;
        }
        explore(x + 1, y);
        explore(x - 1, y);
        explore(x, y + 1);
        explore(x, y - 1);
    }
}

class SolutionTest {

    @Test
    void case1() {
        var grid = new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        var result = new Solution().numIslands(grid);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        var grid = new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        var result = new Solution().numIslands(grid);

        assertThat(result).isEqualTo(3);
    }
}
