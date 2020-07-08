class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        return false;
    }

    // java Solution.java "[[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]" "true" "[[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]" "false" "[[1,1,3,3],[3,1,4,2],[1,3,2,4],[3,2,4,4]]" "false" "[[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String rectangles = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: rectangles = %s",
                new Solution().isRectangleCover(array(rectangles)), expected, rectangles));
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
