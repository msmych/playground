class Solution {

    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        for (var i = 0; i < matrix.length - 1; i++) {
            for (var j = i; j < matrix.length - i - 1; j++) {
                var temp1 = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = matrix[i][j];
                var temp2 = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = temp1;
                var temp3 = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = temp2;
                matrix[i][j] = temp3;
            }
        }
    }

    // java Solution.java "[[1,2,3],[4,5,6],[7,8,9]]" "[[7,4,1],[8,5,2],[9,6,3]]" "[[ 5, 1, 9,11],[ 2, 4, 8,10],[13, 3, 6, 7],[15,14,12,16]]" "[[15,13, 2, 5],[14, 3, 4, 1],[12, 6, 8, 9],[16, 7,10,11]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var matrix = array(args[i]);
            var expected = args[i + 1];
            new Solution().rotate(matrix);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: matrix = %s",
                string(matrix), expected, args[i]));
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
