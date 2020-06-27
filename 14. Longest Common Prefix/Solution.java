class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        var sb = new StringBuilder();
        while (true) {
            if (strs[0].length() <= sb.length()) {
                break;
            }
            var c = strs[0].charAt(sb.length());
            var isCommon = true;
            for (var str : strs) {
                if (str.length() <= sb.length() || str.charAt(sb.length()) != c) {
                    isCommon = false;
                    break;
                }
            }
            if (isCommon) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    // java Solution.java "[flower,flow,flight]" "fl" "[dog,racecar,car]" ""
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String strs = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: strs = %s",
                new Solution().longestCommonPrefix(array(strs)), expected, strs));
        }
    }

    private static String[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
