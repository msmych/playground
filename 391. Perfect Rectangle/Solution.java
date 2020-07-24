import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    private static class Line {
        int a, b, c;
        boolean isHorizontal;

        Line(int a, int b, int c, boolean isHorizontal) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.isHorizontal = isHorizontal;
        }

        Line(int x1, int y1, int x2, int y2) {
            if (x1 == x2) {
                this.c = x1;
                this.a = y1 < y2 ? y1 : y2;
                this.b = y1 < y2 ? y2 : y1;
                this.isHorizontal = false;
            } else {
                this.c = y1;
                this.a = x1 < x2 ? x1 : x2;
                this.b = x1 < x2 ? x2 : x1;
                this.isHorizontal = true;
            }
        }
    }

    private Set<List<Line>> shapes = new HashSet<>();

    public boolean isRectangleCover(int[][] rectangles) {
        for (var rectangle : rectangles) {
            var rect = lines(rectangle);
            var merged = rect;
            for (var iterator = shapes.iterator(); iterator.hasNext();) {
                var shape = iterator.next();
                var sharedLines = sharedLines(rect, shape);
                if (!sharedLines.isEmpty()) {
                    merge(merged, shape, sharedLines);
                    iterator.remove();
                }
            }
        }
        return shapes.size() == 1 && shapes.iterator().next().size() == 4; 
    }

    private List<Line> lines(int[] rectangle) {
        return List.of(
            new Line(r[0], r[1], r[0], r[3]),
            new Line(r[0], r[3], r[2], r[3]),
            new Line(r[2], r[3], r[2], r[1]),
            new Line(r[2], r[1], r[0], r[1]));
    }

    private List<Line> sharedLines(List<Line> s1, List<Line> s2) {
        var shared = new ArrayList<Line>();
        for (var a : s1) {
            for (var b : s2) {
                if (a.isHorizontal != b.isHorizontal || a.c != b.c) {
                    continue;
                }
                if (a.a <= b.a && a.b >= b.a) {
                    shared.add(new Line(b.a, min(a.b, b.b), a.c, a.isHorizontal));
                } else if (a.a >= b.a && a.a <= b.b) {
                    shared.add(new Line(a.a, min(a.b, b.b), a.c, a.isHorizontal));
                }
            }
        }
        return shared;
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
