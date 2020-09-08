import java.util.*;
import java.util.stream.*;

import static java.util.Arrays.*;
import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {

    private static class Point {
        int x;
        int h;
        boolean isLeft;

        public Point(int x, int h, boolean isLeft) {
            this.x = x;
            this.h = h;
            this.isLeft = isLeft;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> points = stream(buildings)
                .flatMap(b -> Stream.of(new Point(b[0], b[2], true), new Point(b[1], b[2], false)))
                .sorted(comparingInt(p -> p.x))
                .collect(toList());
        var skyline = new ArrayList<List<Integer>>();
        var queue = new PriorityQueue<Integer>(reverseOrder());
        queue.offer(0);
        int lastMax = 0, i = 0;
        while (i < points.size()) {
            var x = points.get(i).x;
            for (; i < points.size() && points.get(i).x == x; i++) {
                var p = points.get(i);
                if (p.isLeft) {
                    queue.offer(p.h);
                } else {
                    queue.remove(p.h);
                }
            }
            if (queue.peek() != lastMax) {
                skyline.add(List.of(x, queue.peek()));
                lastMax = queue.peek();
            }
        }
        return skyline;
    }

    // java Solution.java "[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]" "[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String buildings = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: buildings = %s",
                new Solution().getSkyline(intArrArr(buildings)), expected, buildings));
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
