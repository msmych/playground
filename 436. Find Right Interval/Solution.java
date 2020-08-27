import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    private static class Interval {
        int i, start, end;

        Interval(int i, int start, int end) {
            this.i = i;
            this.start = start;
            this.end = end;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        var indexed = range(0, intervals.length)
            .mapToObj(i -> new Interval(i, intervals[i][0], intervals[i][1]))
            .sorted(comparingInt(interval -> interval.start))
            .collect(toList());
        var minRights = new int[intervals.length];
        for (var i = 0; i < indexed.size(); i++) {
            minRights[indexed.get(i).i] = minRight(indexed, i);
        }
        return minRights;
    }

    private int minRight(List<Interval> intervals, int i) {
        var interval = intervals.get(i);
        int left = i + 1, right = intervals.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (intervals.get(mid).start >= interval.end) {
                if (mid == 0 || intervals.get(mid - 1).start < interval.end) {
                    return intervals.get(mid).i;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return left < intervals.size() && intervals.get(left).start >= interval.end ? intervals.get(left).i : -1;
    }

    // java Solution.java "[ [1,2] ]" "[-1]" "[ [3,4], [2,3], [1,2] ]" "[-1, 0, 1]" "[ [1,4], [2,3], [3,4] ]" "[-1, 2, -1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String intervals = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: intervals = %s",
                string(new Solution().findRightInterval(intArrArr(intervals))), expected, intervals));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
