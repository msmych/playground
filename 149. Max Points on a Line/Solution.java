import java.util.Map;
import java.util.HashMap;

import static java.lang.Math.max;

class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generageGcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (map.containsKey(x)) {
                    map.get(x).merge(y, 1, Integer::sum);
                } else {
                    Map<Integer, Integer> xmap = new HashMap<>();
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

    private int generageGcd(int a, int b) {
        return b == 0 ? a : generageGcd(b, a % b);
    }

    // java Solution.java "[[1,1],[2,2],[3,3]]" "3" "[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String points = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: points = %s",
                new Solution().maxPoints(array(points)), expected, points));
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
