class Solution {
    public int maxStudents(char[][] seats) {
        return 0;
    }

    // java Solution.java "[[\#,.,\#,\#,.,\#],[.,\#,\#,\#,\#,.],[\#,.,\#,\#,.,\#]]" "4" "[[.,\#],[\#,\#],[\#,.],[\#,\#],[.,\#]]" "3" "[[\#,.,.,.,\#],[.,\#,.,\#,.],[.,.,\#,.,.],[.,\#,.,\#,.],[\#,.,.,.,\#]]" "10"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String seats = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: seats = %s",
                new Solution().maxStudents(array(seats)), expected, seats));
        }
    }

    private static char[][] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new char[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new char[0][0];
        char[][] arr = new char[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = elements[j].charAt(0);
        }
        return arr;
    }
}
