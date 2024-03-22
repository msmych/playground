package uk.matvey.problems.leet1391;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private enum Direction {
        UP, RIGHT, DOWN, LEFT
    }

    private int[][] grid;

    public boolean hasValidPath(int[][] grid) {
        this.grid = grid;
        if (grid.length == 1 && grid[0].length == 1) {
            return true;
        }
        if (grid[0][0] == 5) {
            return false;
        }
        if (grid[0][0] == 4) {
            var visited = new HashSet<Integer>();
            visited.add(0);
            return (travel(0, 1, Direction.RIGHT, visited) || travel(1, 0, Direction.DOWN, visited));
        }
        Direction direction;
        if (grid[0][0] == 1 || grid[0][0] == 3) {
            direction = Direction.RIGHT;
        } else {
            direction = Direction.DOWN;
        }
        return travel(0, 0, direction, new HashSet<>());
    }

    private boolean travel(int i, int j, Direction direction, Set<Integer> visited) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return direction == Direction.DOWN && (grid[i][j] == 2 || grid[i][j] == 5 || grid[i][j] == 6) ||
                direction == Direction.RIGHT && (grid[i][j] == 1 || grid[i][j] == 3 || grid[i][j] == 5);
        }
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
            || visited.contains(1024 * i + j)) {
            return false;
        }
        visited.add(1024 * i + j);
        return switch (grid[i][j]) {
            case 1 -> {
                if (direction == Direction.RIGHT) {
                    yield travel(i, j + 1, Direction.RIGHT, visited);
                } else if (direction == Direction.LEFT) {
                    yield travel(i, j - 1, Direction.LEFT, visited);
                }
                yield false;
            }
            case 2 -> {
                if (direction == Direction.DOWN) {
                    yield travel(i + 1, j, Direction.DOWN, visited);
                } else if (direction == Direction.UP) {
                    yield travel(i - 1, j, Direction.UP, visited);
                }
                yield false;
            }
            case 3 -> {
                if (direction == Direction.RIGHT) {
                    yield travel(i + 1, j, Direction.DOWN, visited);
                } else if (direction == Direction.UP) {
                    yield travel(i, j - 1, Direction.LEFT, visited);
                }
                yield false;
            }
            case 4 -> {
                if (direction == Direction.UP) {
                    yield travel(i, j + 1, Direction.RIGHT, visited);
                } else if (direction == Direction.LEFT) {
                    yield travel(i + 1, j, Direction.DOWN, visited);
                }
                yield false;
            }
            case 5 -> {
                if (direction == Direction.RIGHT) {
                    yield travel(i - 1, j, Direction.UP, visited);
                } else if (direction == Direction.DOWN) {
                    yield travel(i, j - 1, Direction.LEFT, visited);
                }
                yield false;
            }
            case 6 -> {
                if (direction == Direction.DOWN) {
                    yield travel(i, j + 1, Direction.RIGHT, visited);
                } else if (direction == Direction.LEFT) {
                    yield travel(i - 1, j, Direction.UP, visited);
                }
                yield false;
            }
            default -> false;
        };
    }
}

class SolutionTest {

    @Test
    void case1() {
        var grid = new int[][]{
            {2, 4, 3}, {6, 5, 2}
        };

        assertThat(new Solution().hasValidPath(grid)).isTrue();
    }

    @Test
    void case2() {
        var grid = new int[][]{
            {1, 2, 1}, {1, 2, 1}
        };

        assertThat(new Solution().hasValidPath(grid)).isFalse();
    }

    @Test
    void case3() {
        var grid = new int[][]{
            {1, 1, 2}
        };

        assertThat(new Solution().hasValidPath(grid)).isFalse();
    }

    @Test
    void case4() {
        var grid = new int[][]{
            {1, 1, 1, 1, 1, 1, 3}
        };

        assertThat(new Solution().hasValidPath(grid)).isTrue();
    }

    @Test
    void case5() {
        var grid = new int[][]{
            {2}, {2}, {2}, {2}, {2}, {2}, {6}
        };

        assertThat(new Solution().hasValidPath(grid)).isTrue();
    }

    @Test
    void case6() {
        var grid = new int[][]{
            {4, 1}, {6, 1}
        };

        assertThat(new Solution().hasValidPath(grid)).isTrue();
    }

    @Test
    void case7() {
        var grid = new int[][]{
            {6, 1, 3}, {4, 1, 5}
        };

        assertThat(new Solution().hasValidPath(grid)).isTrue();
    }
}
