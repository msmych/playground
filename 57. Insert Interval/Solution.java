import java.util.*;

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{ newInterval };
        }
        var start = -1;
        if (intervals[0][0] > newInterval[0]) {
            start = newInterval[0];
        }
        var nextIntervals = new ArrayList<int[]>();
        var merged = false;
        for (var interval : intervals) {
            if (!merged && interval[0] > newInterval[1]) {
                if (start == -1) {
                    start = newInterval[0];
                }
                nextIntervals.add(new int[]{ start, newInterval[1] });
                nextIntervals.add(interval);
                merged = true;
                continue;
            }
            if (interval[1] < newInterval[0] || interval[0] > newInterval[1]) {
                nextIntervals.add(interval);
                continue;
            }
            if (start == -1) {
                start = interval[0] > newInterval[0] ? newInterval[0] : interval[0];
            }
            if (interval[1] >= newInterval[1]) {
                nextIntervals.add(new int[]{ start, interval[1] });
                merged = true;
            }
        }
        if (!merged) {
            nextIntervals.add(start == -1 ? newInterval : new int[]{ start, newInterval[1] });
        }
        return nextIntervals.toArray(new int[][]{});
    }

    // java Solution.java "[[1,3],[6,9]]" "[2,5]" "[[1,5],[6,9]]" "[[1,2],[3,5],[6,7],[8,10],[12,16]]" "[4,8]" "[[1,2],[3,10],[12,16]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String intervals = args[i], newInterval = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: intervals = %s, newInterval = %s",
                string(new Solution().insert(int2dArray(intervals), intArray(newInterval))), expected, intervals, newInterval));
        }
    }

    private static int[] intArray(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }

    private static int[][] int2dArray(String s) {
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
