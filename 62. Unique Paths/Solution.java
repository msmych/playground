import java.util.*;

class Solution {

    private static class Grid {
        int m, n;

        Grid(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Grid grid = (Grid) o;
            return m == grid.m && n == grid.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(m, n);
        }
    }

    private final Map<Grid, Integer> cache = new HashMap<>();

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n <= 2 || m <= 2 && n == 1) {
            return 1;
        }
        var grid = new Grid(m, n);
        if (cache.containsKey(grid)) {
            return cache.get(grid);
        }
        var count = uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
        cache.put(grid, count);
        return count;
    }

    // java Solution.java "3" "2" "3" "7" "3" "28"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String m = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: m = %s, n = %s",
                new Solution().uniquePaths(Integer.parseInt(m), Integer.parseInt(n)), expected, m, n));
        }
    }
}
