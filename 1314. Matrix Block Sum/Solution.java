import static java.lang.Math.min;
import static java.lang.Math.max;

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] blockSums = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int blockSum = 0;
                for (int bi = max(0, i - K); bi <= min(mat.length - 1, i + K); bi++) {
                    for (int bj = max(0, j - K); bj <= min(mat[i].length - 1, j + K); bj++) {
                        blockSum += mat[bi][bj];
                    }
                }
                blockSums[i][j] = blockSum;
            }
        }
        return blockSums;
    }

    // java Solution.java "[[1,2,3],[4,5,6],[7,8,9]]" 1 "[[12,21,16],[27,45,33],[24,39,28]]" "[[1,2,3],[4,5,6],[7,8,9]]" 2 "[[45,45,45],[45,45,45],[45,45,45]]" "[[67,64,78],[99,98,38],[82,46,46],[6,52,55],[55,99,45]]" 3 "[[731,731,731],[930,930,930],[930,930,930],[930,930,930],[721,721,721]]"
    public static void main(String... args) {
        Solution solution = new Solution();
        args = new String[]{"[[67,64,78],[99,98,38],[82,46,46],[6,52,55],[55,99,45]]", "3", "[?]"};
        for (int i = 0; i < args.length; i += 3) {
            String mat = args[i], K = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: mat = %s, K = %s",
                string(solution.matrixBlockSum(array(mat), Integer.parseInt(K))), expected, mat, K));
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
