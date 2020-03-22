import java.util.Set;
import java.util.HashSet;

class Solution {

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
            Set<Integer> visited = new HashSet<>();
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
        switch (grid[i][j]) {
            case 1:
                if (direction == Direction.RIGHT) {
                    return travel(i, j + 1, Direction.RIGHT, visited);
                } else if (direction == Direction.LEFT) {
                    return travel(i, j - 1, Direction.LEFT, visited);
                }
                return false;
            case 2:
                if (direction == Direction.DOWN) {
                    return travel(i + 1, j, Direction.DOWN, visited);
                } else if (direction == Direction.UP) {
                    return travel(i - 1, j, Direction.UP, visited);
                }
                return false;
            case 3:
                if (direction == Direction.RIGHT) {
                    return travel(i + 1, j, Direction.DOWN, visited);
                } else if (direction == Direction.UP) {
                    return travel(i, j - 1, Direction.LEFT, visited);
                }
                return false;
            case 4:
                if (direction == Direction.UP) {
                    return travel(i, j + 1, Direction.RIGHT, visited);
                } else if (direction == Direction.LEFT) {
                    return travel(i + 1, j, Direction.DOWN, visited);
                }
                return false;
            case 5:
                if (direction == Direction.RIGHT) {
                    return travel(i - 1, j, Direction.UP, visited);
                } else if (direction == Direction.DOWN) {
                    return travel(i, j - 1, Direction.LEFT, visited);
                }
                return false;
            case 6:
                if (direction == Direction.DOWN) {
                    return travel(i, j + 1, Direction.RIGHT, visited);
                } else if (direction == Direction.LEFT) {
                    return travel(i - 1, j, Direction.UP, visited);
                }
                return false;
        }
        return false;
    }

    // java Solution.java "[[2,4,3],[6,5,2]]" "true" "[[1,2,1],[1,2,1]]" "false" "[[1,1,2]]" "false" "[[1,1,1,1,1,1,3]]" "true" "[[2],[2],[2],[2],[2],[2],[6]]" "true" "[[4,1],[6,1]]" true "[[6,1,3],[4,1,5]]" true
    public static void main(String... args) {
        new Solution().hasValidPath(array("[[6,1,3],[4,1,5]]"));
        for (int i = 0; i < args.length; i += 2) {
            String grid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: grid = %s",
                new Solution().hasValidPath(array(grid)), expected, grid));
        }
    }

    private static int[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new int[0][0];
        int[][] arr = new int[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.parseInt(elements[j]);
        }
        return arr;
    }
}
