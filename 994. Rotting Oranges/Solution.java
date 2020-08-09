import java.util.*;

class Solution {

    private static class Orange {
        int i, j;

        Orange(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int lastRottenCount = -1, minutes = 0;
        while (getGood(grid).size() > 0) {
            var rottenOranges = getRotten(grid);
            if (rottenOranges.size() == lastRottenCount) {
                return -1;
            }
            lastRottenCount = rottenOranges.size();
            for (var rottenOrange : getRotten(grid)) {
                int i = rottenOrange.i, j = rottenOrange.j;
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                }
                if (i > 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                }
                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                }
            }
            minutes++;
        }
        return minutes;
    }

    private Set<Orange> getRotten(int[][] grid) { 
        return getOranges(grid, 2); 
    }

    private Set<Orange> getGood(int[][] grid) { 
        return getOranges(grid, 1); 
    }

    private Set<Orange> getOranges(int[][] grid, int kind) {
        var good = new HashSet<Orange>();
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == kind) {
                    good.add(new Orange(i, j));
                }
            }
        }
        return good;
    }

    // java Solution.java "[[2,1,1],[1,1,0],[0,1,1]]" "4" "[[2,1,1],[0,1,1],[1,0,1]]" "-1" "[[0,2]]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String grid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: grid = %s",
                new Solution().orangesRotting(intArrArr(grid)), expected, grid));
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
