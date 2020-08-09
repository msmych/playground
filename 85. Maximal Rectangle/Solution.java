import java.util.*;

class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        var histogram = new int[matrix[0].length];
        for (var i = 0; i < matrix[0].length; i++) {
            histogram[i] = matrix[0][i] - '0';
        }
        var max = maxArea(histogram);
        for (var i = 1; i < matrix.length; i++) {
            for (var j = 0; j < matrix[i].length; j++) {
                histogram[j] = matrix[i][j] == '0' ? 0 : histogram[j] + 1;
            }
            var area = maxArea(histogram);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    private int maxArea(int[] histogram) {
        var stack = new Stack<Integer>();
        var max = 0;
        for (var i = 0; i <= histogram.length; i++) {
            var last = i == histogram.length ? -1 : histogram[i];
            while (!stack.isEmpty() && histogram[stack.peek()] > last) {
                var height = histogram[stack.pop()];
                var width = stack.isEmpty() ? i : i - stack.peek() - 1;
                var area = height * width;
                if (area > max) { 
                    max = area;
                }
            }
            stack.push(i);
      }
      return max;
    }

    // java Solution.java "[[1,0,1,0,0],[1,0,1,1,1],[1,1,1,1,1],[1,0,0,1,0]]" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String matrix = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s",
                new Solution().maximalRectangle(charArrArr(matrix)), expected, matrix));
        }
    }

    private static char[][] charArrArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new char[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new char[0][0];
        char[][] arr = new char[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = elements[j].charAt(0);
        }
        return arr;
    }
}
