class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0, right = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / matrix[0].length, j = mid % matrix[0].length;
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // java Solution.java "[[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]" "3" "true" "[[1,   3,  5,  7],[10, 11, 16, 20],[23, 30, 34, 50]]" "13" "false"
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
