class Solution {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        return 0;
    }

    // java Solution.java "4" "[[2,1],[3,1],[1,4]]" "2" "3" "5" "[[2,1],[3,1],[4,1],[1,5]]" "2" "4" "11" "[]" "2" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], dependencies = args[i + 1], k = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, dependencies = %s, k = %s",
                new Solution().minNumberOfSemesters(Integer.parseInt(n), array(dependencies), Integer.parseInt(k)), expected, n, dependencies, k));
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
}
