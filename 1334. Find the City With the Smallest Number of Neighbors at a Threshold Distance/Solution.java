class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        return 0;
    }

    // java Solution.java "4" "[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]" "4" "3" "5" "[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]" "2" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String n = args[i], edges = args[i + 1], distanceThreshold = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, edges = %s, distanceThreshold = %s",
                new Solution().findTheCity(Integer.parseInt(n), array(edges), Integer.parseInt(distanceThreshold)), expected, n, edges, distanceThreshold));
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
