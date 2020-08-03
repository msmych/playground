import java.util.*;

class Solution {

    private static class Position {
        int i, j;

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return i == position.i &&
                    j == position.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private final Map<Position, Integer> cache = new HashMap<>();

    private int[][] grid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        if (grid[grid.length - 1][grid[0].length - 1] == 1) {
            return 0;
        }
        return uniquePaths(0, 0);
    }

    private int uniquePaths(int i, int j) {
        if (i == grid.length || j == grid[0].length || grid[i][j] == 1) {
            return 0;
        }
        if (i == grid.length - 1 && j >= grid[0].length - 2 || i >= grid.length - 2 && j == grid[0].length - 1) {
            return 1;
        }
        var position = new Position(i, j);
        if (cache.containsKey(position)) {
            return cache.get(position);
        }
        var count = uniquePaths(i, j + 1) + uniquePaths(i + 1, j);
        cache.put(position, count);
        return count;
    }

    // java Solution.java "[[0,0,0],[0,1,0],[0,0,0]]" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String obstacleGrid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: obstacleGrid = %s",
                new Solution().uniquePathsWithObstacles(intArrArr(obstacleGrid)), expected, obstacleGrid));
        }
    }

    private static int[][] intArrArr(String s) {
        s = s.replace(" ", "");
        if (s.equals("[[]]")) return new int[0][0];
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        var arr = new int[rows.length][];
        for (var i = 0; i < arr.length; i++) {
            var row = rows[i].replace("[", "").replace("]", "");
            if (row.isEmpty()) {
                arr[i] = new int[0];
                continue;
            }
            var els = row.split(",");
            arr[i] = new int[els.length];
            for (var j = 0; j < arr[i].length; j++) arr[i][j] = Integer.parseInt(els[j]);
        }
        return arr;
    }
}
