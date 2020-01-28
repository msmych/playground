class Solution {
    public int[][] diagonalSort(int[][] mat) {
        return new int[0][0];
    }

    // java Solution.java "[[3,3,1,1],[2,2,1,2],[1,1,1,2]]" "[[1,1,1,1],[1,2,2,2],[1,2,3,3]]"
    public static void main(String... args) {
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
