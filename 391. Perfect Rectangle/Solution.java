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
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            var that = (Point) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE, y1 = x1, x2 = Integer.MIN_VALUE, y2 = x2;
        var visited = new HashSet<Point>();
        var area = 0;
        for (var rect : rectangles) {
            if (rect[0] < x1) {
                x1 = rect[0];
            }
            if (rect[1] < y1) {
                y1 = rect[1];
            }
            if (rect[2] > x2) {
                x2 = rect[2];
            }
            if (rect[3] > y2) {
                y2 = rect[3];
            }
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            var p1 = new Point(rect[0], rect[1]);
            var p2 = new Point(rect[0], rect[3]);
            var p3 = new Point(rect[2], rect[3]);
            var p4 = new Point(rect[2], rect[1]);
            if (!visited.add(p1)) {
                visited.remove(p1);
            }
            if (!visited.add(p2)) {
                visited.remove(p2);
            }
            if (!visited.add(p3)) {
                visited.remove(p3);
            }
            if (!visited.add(p4)) {
                visited.remove(p4);
            }
        }
        return visited.equals(Set.of(new Point(x1, y1), new Point(x1, y2), new Point(x2, y1), new Point(x2, y2))) && 
            area == (x2 - x1) * (y2 - y1);
    }

    // java Solution.java "[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]" "true" "[[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]" "false" "[[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]" "false" "[[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String rectangles = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: rectangles = %s",
                new Solution().isRectangleCover(array(rectangles)), expected, rectangles));
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
