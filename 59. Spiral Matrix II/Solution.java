class Solution {

    private final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;

    private int direction = RIGHT, i = 0, j = 0, rightBorder, downBorder, leftBorder = 0, upBorder = 0;

    public int[][] generateMatrix(int n) {
        var matrix = new int[n][n];
        downBorder = n - 1;
        rightBorder = n - 1;
        for (var k = 1; k <= n * n; k++) {
            matrix[i][j] = k;
            updateIndexes();
        }
        return matrix;
    }

    private void updateIndexes() {
        switch (direction) {
            case RIGHT:
                goRight();
                break;
            case DOWN:
                goDown();
                break;
            case LEFT:
                goLeft();
                break;
            case UP:
                goUp();
        }
    }

    private void goRight() {
        if (++j == rightBorder) {
            direction = DOWN;
            upBorder++;
        }
    }

    private void goDown() {
        if (++i == downBorder) {
            direction = LEFT;
            rightBorder--;
        }
    }

    private void goLeft() {
        if (--j == leftBorder) {
            direction = UP;
            downBorder--;
        }
    }

    private void goUp() {
        if (--i == upBorder) {
            direction = RIGHT;
            leftBorder++;
        }
    }

    // java Solution.java "3" "[[ 1, 2, 3 ],[ 8, 9, 4 ],[ 7, 6, 5 ]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                string(new Solution().generateMatrix(Integer.parseInt(n))), expected, n));
        }
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
