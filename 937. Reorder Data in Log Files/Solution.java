import java.util.*;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

class Solution {

    public String[] reorderLogFiles(String[] logs) {
        var digits = List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        var separated = stream(logs).collect(groupingBy(log -> digits.contains(log.split(" ")[1].charAt(0))));
        var ordered = new LinkedList<String>();
        ordered.addAll(separated.get(false).stream().sorted((log1, log2) -> {
            String[] parts1 = log1.split(" "), parts2 = log2.split(" ");
            for (var i = 1; i < (parts1.length > parts2.length ? parts1.length : parts2.length); i++) {
                if (i >= parts1.length) {
                    return 1;
                }
                if (i >= parts2.length) {
                    return -1;
                }
                var comp = compare(parts1[i], parts2[i]);
                if (comp != 0) {
                    return comp;
                }
            }
            return compare(parts1[0], parts2[0]);
        }).collect(toList()));
        ordered.addAll(separated.get(true));
        return ordered.toArray(new String[]{});
    }

    private int compare(String s1, String s2) {
        for (var i = 0; i < (s1.length() > s2.length() ? s1.length() : s2.length()); i++) {
            if (i >= s1.length()) {
                return -1;
            }
            if (i >= s2.length()) {
                return 1;
            }
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 > c2) {
                return 1;
            }
            if (c1 < c2) {
                return -1;
            }
        }
        return 0;
    }

    // java Solution.java "[dig1 8 1 5 1,let1 art can,dig2 3 6,let2 own kit dig,let3 art zero]" "[let1 art can,let3 art zero,let2 own kit dig,dig1 8 1 5 1,dig2 3 6]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String logs = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: logs = %s",
                string(new Solution().reorderLogFiles(stringArr(logs))), expected, logs));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }

    private static String string(String[] arr) {
        var s = "";
        for (var e : arr) s += "," + e;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
