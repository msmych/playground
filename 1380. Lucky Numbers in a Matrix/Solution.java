import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> lucky = new ArrayList<>();
        int[] minRows = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            minRows[i] = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < minRows[i]) {
                    minRows[i] = matrix[i][j];
                }
            }
        }
        int[] maxCols = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            maxCols[j] = matrix[0][j];
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > maxCols[j]) {
                    maxCols[j] = matrix[i][j];
                }
            }
        }
        for (int min : minRows) {
            for (int max : maxCols) {
                if (min == max) {
                    lucky.add(max);
                }
            }
        }
        return lucky;
    }

    // java Solution.java "[[3,7,8],[9,11,13],[15,16,17]]" "[15]" "[[1,10,4,2],[9,3,8,7],[15,16,17,12]]" "[12]" "[[7,8],[1,2]]" "[7]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String matrix = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s",
                new Solution().luckyNumbers(array(matrix)), expected, matrix));
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
