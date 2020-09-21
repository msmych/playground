import java.util.*;

import static java.util.Arrays.*;

class Solution {

    private int[][] grid;
    private long cells;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        cells = stream(grid).mapToLong(row -> stream(row).filter(c -> c == 0).count()).sum();
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return nextPaths(i - 1, j, new ArrayList<>()) +
                        nextPaths(i, j + 1, new ArrayList<>()) +
                        nextPaths(i + 1, j, new ArrayList<>()) +
                        nextPaths(i, j - 1, new ArrayList<>());
                }
            }
        }
        throw new IllegalArgumentException();
    }

    private int nextPaths(int i, int j, List<Integer> visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1 || grid[i][j] == 1 || visited.contains(1000 * i + j)) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return visited.size() == cells ? 1 : 0;
        }
        visited.add(1000 * i + j);
        return nextPaths(i - 1, j, new ArrayList<>(visited)) +
            nextPaths(i, j + 1, new ArrayList<>(visited)) +
            nextPaths(i + 1, j, new ArrayList<>(visited)) +
            nextPaths(i, j - 1, new ArrayList<>(visited));
    }

    // java Solution.java "[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]" "2" "[[1,0,0,0],[0,0,0,0],[0,0,0,2]]" "4" "[[0,1],[2,0]]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String grid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: grid = %s",
                new Solution().uniquePathsIII(intArrArr(grid)), expected, grid));
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
