class Solution {

    private int[][] matrix;
    private int target;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        this.matrix = matrix;
        this.target = target;
        return searchNext(0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean searchNext(int i1, int j1, int i2, int j2) {
        if (i1 == i2) {
            return searchInRow(i1, j1, j2);
        }
        if (j1 == j2) {
            return searchInColumn(j1, i1, i2);
        }
        int col = (j2 + j1) / 2;
        for (var i = i1; i <= i2; i++) {
            if (matrix[i][col] >= target) {
                if (i == i2 && col == j1) {
                    return matrix[i][col] == target || searchNext(i1, col + 1, i2, j2);
                }
                return searchNext(i, j1, i2, col) || searchNext(i1, col, i, j2);
            }
        }
        return searchNext(i1, col + 1, i2, j2);
    }

    private boolean searchInRow(int i, int j1, int j2) {
        while (j1 <= j2) {
            int mid = (j1 + j2) / 2;
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] < target) {
                j1++;
            } else {
                j2--;
            }
        }
        return false;
    }

    private boolean searchInColumn(int j, int i1, int i2) {
        while (i1 <= i2) {
            int mid = (i1 + i2) / 2;
            if (matrix[mid][j] == target) {
                return true;
            } else if (matrix[mid][j] < target) {
                i1++;
            } else {
                i2--;
            }
        }
        return false;
    }

    // java Solution.java "[[1,   4,  7, 11, 15],[2,   5,  8, 12, 19],[3,   6,  9, 16, 22],[10, 13, 14, 17, 24],[18, 21, 23, 26, 30]]" "5" "true" "[[1,   4,  7, 11, 15],[2,   5,  8, 12, 19],[3,   6,  9, 16, 22],[10, 13, 14, 17, 24],[18, 21, 23, 26, 30]]" "20" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String matrix = args[i], target = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s, target = %s",
                new Solution().searchMatrix(intArrArr(matrix), Integer.parseInt(target)), expected, matrix, target));
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
