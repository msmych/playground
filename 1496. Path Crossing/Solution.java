import java.util.*;

class Solution {

    private static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            var that = (Point) o;
            return that.i == i && that.j == j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public boolean isPathCrossing(String path) {
        var visited = new HashSet<Point>();
        var p = new Point(0, 0);
        visited.add(p);
        for (var step : path.toCharArray()) {
            switch (step) {
                case 'N':
                    p = new Point(p.i + 1, p.j);
                    break;
                case 'S':
                    p = new Point(p.i - 1, p.j);
                    break;
                case 'E':
                    p = new Point(p.i, p.j + 1);
                    break;
                case 'W':
                    p = new Point(p.i, p.j - 1);
            }
            if (visited.contains(p)) {
                return true;
            }
            visited.add(p);
        } 
        return false;
    }

    // java Solution.java "NES" "false" "NESWW" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String path = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: path = %s",
                new Solution().isPathCrossing(path), expected, path));
        }
    }
}
