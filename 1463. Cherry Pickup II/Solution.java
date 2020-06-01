class Solution {
    public int cherryPickup(int[][] grid) {
        return 0;
    }

    // java Solution.java "[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]" "24" "[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]" "28" "[[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]" "22" "[[1,1],[1,1]]" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String grid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: grid = %s",
                new Solution().cherryPickup(array(grid)), expected, grid));
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
