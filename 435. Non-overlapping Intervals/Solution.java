class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return 0;
    }

    // java Solution.java "[[1,2],[2,3],[3,4],[1,3]]" "1" "[[1,2],[1,2],[1,2]]" "2" "[[1,2],[2,3]]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String intervals = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: intervals = %s",
                new Solution().eraseOverlapIntervals(intArrArr(intervals)), expected, intervals));
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
