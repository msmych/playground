class Solution {
    public int[][] reconstructQueue(int[][] people) {
        return new int[0][0];
    }

    // java Solution.java "[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]" "[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String people = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: people = %s",
                string(new Solution().reconstructQueue(array(people))), expected, people));
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
