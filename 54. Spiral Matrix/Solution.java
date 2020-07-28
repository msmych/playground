import java.util.*;

class Solution {

    private enum Direction { RIGHT, DOWN, LEFT, UP }

    private Direction direction = Direction.RIGHT;
    private int i = 0, j = 0;
    private int leftBorder = 0, rightBorder, upBorder = 1, downBorder;

    public List<Integer> spiralOrder(int[][] matrix) {
        var result = new ArrayList<Integer>();
        var m = matrix.length;
        if (m == 0) {
            return result;
        }
        var n = matrix[0].length;
        downBorder = m - 1;
        rightBorder = n - 1;
        for (var index = 0; index < m * n; index++) {
            result.add(matrix[i][j]);
            updateIndexes();
        }
        return result;
    }

    private void updateIndexes() {
        switch (direction) {
            case RIGHT:
                updateRight();
                break;
            case DOWN:
                updateDown();
                break;
            case LEFT:
                updateLeft();
                break;
            case UP:
                updateUp();
        }
    }

    private void updateRight() {
        if (j == rightBorder) {
            direction = Direction.DOWN;
            i++;
            rightBorder--;
        } else {
            j++;
        }
    }

    private void updateDown() {
        if (i == downBorder) {
            direction = Direction.LEFT;
            j--;
            downBorder--;
        } else {
            i++;
        }
    }

    private void updateLeft() {
        if (j == leftBorder) {
            direction = Direction.UP;
            i--;
            leftBorder++;
        } else {
            j--;
        }
    }

    private void updateUp() {
        if (i == upBorder) {
            direction = Direction.RIGHT;
            j++;
            upBorder++;
        } else {
            i--;
        }
    }

    // java Solution.java "[[ 1, 2, 3 ],[ 4, 5, 6 ],[ 7, 8, 9 ]]" "[1,2,3,6,9,8,7,4,5]" "[[1, 2, 3, 4],[5, 6, 7, 8],[9,10,11,12]]" "[1,2,3,4,8,12,11,10,9,5,6,7]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String matrix = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s",
                new Solution().spiralOrder(array(matrix)), expected, matrix));
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
}
