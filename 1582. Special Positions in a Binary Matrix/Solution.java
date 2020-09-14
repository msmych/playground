import java.util.*;

import static java.util.stream.IntStream.*;

class Solution {

    public int numSpecial(int[][] mat) {
        var special = 0;
        Set<Integer> excludedRows = new HashSet<>(), excludedCols = new HashSet<>();
        for (var i = 0; i < mat.length; i++) {
            if (excludedRows.contains(i)) {
                continue;
            }
            for (var j = 0; j < mat[i].length; j++) {
                if (excludedCols.contains(j)) {
                    continue;
                }
                if (mat[i][j] == 0) {
                    continue;
                }
                int row = i, col = j;
                if (range(0, mat.length).filter(k -> k != row).anyMatch(k -> mat[k][col] == 1)) {
                    excludedRows.add(i);
                    continue;
                }
                if (range(0, mat[i].length).filter(k -> k != col).anyMatch(k -> mat[row][k] == 1)) {
                    excludedCols.add(j);
                    continue;
                }
                special++;
            }
        }
        return special;
    }

    // java Solution.java "[[1,0,0],[0,0,1],[1,0,0]]" "1" "[[1,0,0],[0,1,0],[0,0,1]]" "3" "[[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]" "2" "[[0,0,0,0,0],[1,0,0,0,0],[0,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String mat = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: mat = %s",
                new Solution().numSpecial(intArrArr(mat)), expected, mat));
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
