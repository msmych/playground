import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Comparator.*;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        sort(A, comparingInt(arr -> arr[0]));
        sort(B, comparingInt(arr -> arr[0]));
        var intersections = new ArrayList<int[]>();
        for (int i = 0, j = 0; i < A.length && j < B.length;) {
            if (touch(A[i], B[j])) {
                intersections.add(new int[]{max(A[i][0], B[j][0]), A[i][1]});
                i++;
            } else if (touch(B[j], A[i])) {
                intersections.add(new int[]{max(B[j][0], A[i][0]), B[j][1]});
                j++;
            } else {
                if (A[i][0] < B[j][0]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        var arr = new int[intersections.size()][2];
        for (var i = 0; i < intersections.size(); i++) {
            arr[i] = intersections.get(i);
        }
        return arr;
    }

    private boolean touch(int[] a, int[] b) {
        return a[1] >= b[0] && a[1] <= b[1];
    }

    // java Solution.java "[[0,2],[5,10],[13,23],[24,25]]" "[[1,5],[8,12],[15,24],[25,26]]" "[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]" "[[5,10]]" "[[5,6]]" "[[5,6]]" "[[3,5],[9,20]]" "[[4,5],[7,10],[11,12],[14,15],[16,20]]" "[[4,5],[9,10],[11,12],[14,15],[16,20]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String A = args[i], B = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: A = %s, B = %s",
                string(new Solution().intervalIntersection(array(A), array(B))), expected, A, B));
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
