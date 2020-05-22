import java.util.*;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        var max = Integer.MIN_VALUE;
        for (var up = 0; up < matrix.length; up++) {
            var sums = new int[matrix[up].length];
            for (var down = up; down < matrix.length; down++) {
                for (var i = 0; i < matrix[up].length; i++) {
                    sums[i] += matrix[down][i];
                }
                var sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                var current = 0;
                for (var sum : sums) {
                    current += sum;
                    var n = sumSet.ceiling(current - k);
                    if (n != null && current - n > max) {
                        max = current - n;
                    }
                    sumSet.add(current);
                }
            }
        }
        return max;
    }

    // java Solution.java "[[1,0,1],[0,-2,3]]" "2" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String matrix = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s, k = %s",
                new Solution().maxSumSubmatrix(array(matrix), Integer.parseInt(k)), expected, matrix, k));
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
