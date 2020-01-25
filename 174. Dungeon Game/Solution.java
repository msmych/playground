class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        return 0;
    }

    // java Solution.java "[[-2, -3, 3],[-5,-10,1],[10,30,-5]]" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String dungeon = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: dungeon = %s",
                new Solution().calculateMinimumHP(array(dungeon)), expected, dungeon));
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
