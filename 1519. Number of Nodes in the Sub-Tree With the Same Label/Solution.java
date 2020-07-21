class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        return new int[0];
    }

    // java Solution.java "7" "[[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]]" "abaedcd" "[2,1,1,1,1,1,1]" "4" "[[0,1],[1,2],[0,3]]" "bbbb" "[4,2,1,1]" "5" "[[0,1],[0,2],[1,3],[0,4]]" "aabab" "[3,2,1,1,1]" "6" "[[0,1],[0,2],[1,3],[3,4],[4,5]]" "cbabaa" "[1,2,1,1,2,1]" "7" "[[0,1],[1,2],[2,3],[3,4],[4,5],[5,6]]" "aaabaaa" "[6,5,4,1,3,2,1]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], edges = args[i + 1], labels = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, edges = %s, labels = %s",
                string(new Solution().countSubTrees(Integer.parseInt(n), array(edges), labels)), expected, n, edges, labels));
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

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
