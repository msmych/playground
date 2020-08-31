import java.util.*;

import static java.lang.Math.*;

class Solution {

    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        var map = new HashMap<Integer, Map<Integer, Integer>>();
        var count = 0;
        for (var i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (var j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0], y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                var gcd = generateGcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (map.containsKey(x)) {
                    map.get(x).merge(y, 1, Integer::sum);
                } else {
                    var xmap = new HashMap<Integer, Integer>();
                    xmap.put(y, 1);
                    map.put(x, xmap);
                }
                max = max(max, map.get(x).get(y));
            }
            if (max + overlap + 1 > count) {
                count = max + overlap + 1;
            }
        }
        return count;
    }

    private int generateGcd(int a, int b) {
        return b == 0 ? a : generateGcd(b, a % b);
    }

    // java Solution.java "[[1,1],[2,2],[3,3]]" "3" "[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String points = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: points = %s",
                new Solution().maxPoints(intArrArr(points)), expected, points));
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
