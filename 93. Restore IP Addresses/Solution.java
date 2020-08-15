import java.util.*;

import static java.lang.Math.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        return nextIps(s, 4);
    }

    private List<String> nextIps(String s, int n) {
        if (n == 0 || s.isEmpty() || 3 * n < s.length()) {
            return new ArrayList<>();
        }
        if (n == 1) {
            if (s.length() > 1 && s.startsWith("0")) {
                return new ArrayList<>();
            }
            if (Integer.valueOf(s) > 255) {
                return new ArrayList<>();
            }
            return List.of(s);
        }
        var ips = new ArrayList<String>();
        for (var i = 1; i <= min(3, s.length()); i++) {
            var part = s.substring(0, i);
            if (part.length() > 1 && part.startsWith("0")) {
                continue;
            }
            if (Integer.valueOf(part) > 255) {
                continue;
            }
            for (var ip : nextIps(s.substring(i), n - 1)) {
                ips.add(part + '.' + ip);
            }
        }
        return ips;
    }

    // java Solution.java "25525511135" "[255.255.11.135, 255.255.111.35]" "0000" "[0.0.0.0]" "1111" "[1.1.1.1]" "010010" "[0.10.0.10, 0.100.1.0]" "101023" "[1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().restoreIpAddresses(s), expected, s));
        }
    }
}
