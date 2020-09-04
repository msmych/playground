import java.util.*;

class Solution {

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
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

    // java Solution.java "[[1,1,1,1,0],[1,1,0,1,0],[1,1,0,0,0],[0,0,0,0,0]]" "1" "[[1,1,0,0,0],[1,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String grid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: grid = %s",
                new Solution().numIslands(charArrArr(grid)), expected, grid));
        }
    }

    private static char[][] charArrArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new char[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new char[0][0];
        char[][] arr = new char[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = elements[j].charAt(0);
        }
        return arr;
    }
}
