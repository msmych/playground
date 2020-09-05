import static java.util.stream.IntStream.*;

class Solution {

    public int diagonalSum(int[][] mat) {
        var sum = range(0, mat.length).map(i -> mat[i][i] + mat[i][mat.length - i - 1]).sum();
        return mat.length % 2 == 0 ? sum : sum - mat[mat.length / 2][mat.length / 2];
    }

    // java Solution.java "[[1,2,3],[4,5,6],[7,8,9]]" "25" "[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]" "8" "[[5]]" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String mat = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: mat = %s",
                new Solution().diagonalSum(intArrArr(mat)), expected, mat));
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
