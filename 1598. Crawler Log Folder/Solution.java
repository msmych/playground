class Solution {

    public int minOperations(String[] logs) {
        var depth = 0;
        for (var log : logs) {
            if (log.equals("./")) {
                continue;
            }
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else {
                depth++;
            }
        }
        return depth;
    }

    // java Solution.java "[d1/,d2/,../,d21/,./]" "2" "[d1/,d2/,./,d3/,../,d31/]" "3" "[d1/,../,../,../]" "0" "[./,../,./]" 0
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String logs = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: logs = %s",
                new Solution().minOperations(stringArr(logs)), expected, logs));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
