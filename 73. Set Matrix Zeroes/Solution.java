class Solution {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        var columnZero =  false;
        for (var i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnZero = true;
            }
            for (var j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (var i = 1; i < matrix.length; i++) {
            for (var j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (var j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (columnZero) {
            for (var i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // java Solution.java "[[1,1,1],[1,0,1],[1,1,1]]" "[[1,0,1],[0,0,0],[1,0,1]]" "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]" "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var matrix = intArrArr(args[i]);
            String expected = args[i + 1];
            new Solution().setZeroes(matrix);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s",
                string(matrix), expected, args[i]));
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
