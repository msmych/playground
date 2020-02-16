class Solution {
    public int countNegatives(int[][] grid) {
        int neg = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    neg++;
                } else if (j == grid.length - 1) {
                    return neg;
                } else {
                    break;
                }
            }
        }
        return neg;
    }

    // java Solution.java "[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]" "8" "[[3,2],[1,0]]" "0" "[[1,-1],[-1,-1]]" "3" "[[-1]]" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String grid = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: grid = %s",
                new Solution().countNegatives(array(grid)), expected, grid));
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
