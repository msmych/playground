import static java.lang.Math.min;
import static java.util.Arrays.sort;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        if (mat.length == 1) {
            return mat;
        }
        for (int i = 0; i < mat.length - 1; i++) {
            int[] arr = new int[min(mat.length - i, mat[0].length)];
            for (int j = 0; j < min(mat.length - i, mat[0].length); j++) {
                arr[j] = mat[i + j][j];
            }
            sort(arr);
            for (int j = 0; j < min(mat.length - i, mat[0].length); j++) {
                mat[i + j][j] = arr[j];
            }
        }
        for (int j = 1; j < mat[0].length - 1; j++) {
            int[] arr = new int[min(mat.length, mat[0].length - j)];
            for (int i = 0; i < min(mat.length, mat[0].length - j); i++) {
                arr[i] = mat[i][j + i];
            }
            sort(arr);
            for (int i = 0; i < min(mat.length, mat[0].length - j); i++) {
                mat[i][j + i] = arr[i];
            }
        }
        return mat;
    }

    // java Solution.java "[[3,3,1,1],[2,2,1,2],[1,1,1,2]]" "[[1,1,1,1],[1,2,2,2],[1,2,3,3]]" "[[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]" "[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]" "[[37,98,82,45,42]]" "[[37,98,82,45,42]]" "[[75,21,13,24,8],[24,100,40,49,62]]" "[[75,21,13,24,8],[24,100,40,49,62]]"
    public static void main(String... args) {
        new Solution().diagonalSort(array("[[3,3,1,1],[2,2,1,2],[1,1,1,2]]"));
        for (int i = 0; i < args.length; i += 2) {
            String mat = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: mat = %s",
                string(new Solution().diagonalSort(array(mat))), expected, mat));
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
