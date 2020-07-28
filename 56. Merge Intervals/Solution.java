import java.util.*;

import static java.util.Arrays.*;
import static java.util.Comparator.*;

class Solution {

    public int[][] merge(int[][] intervals) {
        sort(intervals, comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        var merged = new ArrayList<int[]>();
        int start = -1, end = -1;
        for (var interval : intervals) {
            if (interval[0] > end) {
                if (end > -1) {
                    merged.add(new int[]{ start, end });
                }
                start = interval[0];
                end = interval[1];
            } else if (interval[1] > end) {
                end = interval[1];
            }
        }
        if (!merged.isEmpty()) {
            var last = merged.get(merged.size() - 1);
            if (last[0] != start) {
                merged.add(new int[]{ start, end });
            }
            else if (last[1] < end) {
                merged.get(merged.size() - 1)[1] = end;
            }
        } else if (end > -1) {
            merged.add(new int[]{ start, end });
        }
        return merged.toArray(new int[][]{});
    }

    // java Solution.java "[[1,3],[2,6],[8,10],[15,18]]" "[[1,6],[8,10],[15,18]]" "[[1,4],[4,5]]" "[[1,5]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String intervals = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: intervals = %s",
                string(new Solution().merge(array(intervals))), expected, intervals));
        }
    }

    private static int[][] array(String s) {
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

    private static String string(int[][] arr) {
        String s = "";
        for (int[] row : arr) {
            String r = "";
            for (int n : row) r += "," + n;
            if (row.length > 0) r = r.substring(1);
            s += ",[" + r + "]";
        }
        if (arr.length > 0) s = s.substring(1);
        return "[" + s + "]";
    }
}
