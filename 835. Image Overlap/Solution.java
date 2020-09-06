class Solution {

    public int largestOverlap(int[][] A, int[][] B) {
        return 0;
    }

    // java Solution.java "[[1,1,0],[0,1,0],[0,1,0]]" "[[0,0,0],[0,1,1],[0,0,1]]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String A = args[i], B = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s, B = %s",
                new Solution().largestOverlap(intArrArr(A), intArrArr(B)), expected, A, B));
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
