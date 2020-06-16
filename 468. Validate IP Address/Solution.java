import static java.util.Arrays.*;

class Solution {
    public String validIPAddress(String IP) {
        if (isIpV4(IP)) {
            return "IPv4";
        }
        if (isIpV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIpV4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".")) {
            return false;
        }
        var parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }
        return stream(parts).allMatch(this::isIpV4Part);
    }

    private boolean isIpV4Part(String s) {
        if (s.equals("0")) {
            return true;
        }
        if (s.startsWith("0")) {
            return false;
        }
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return n > 0 && n < 256;
    }

    private boolean isIpV6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":")) {
            return false;
        }
        var parts = ip.split(":");
        if (parts.length != 8) {
            return false;
        }
        return stream(parts).allMatch(this::isIpV6Part);
    }

    private boolean isIpV6Part(String s) {
        if (s.startsWith("-")) {
            return false;
        }
        if (s.length() > 4) {
            return false;
        }
        int n;
        try {
            n = Integer.parseInt(s, 16);
        } catch (NumberFormatException e) {
            return false;
        }
        return n >= 0;
    }

    // java Solution.java "172.16.254.1" "IPv4" "2001:0db8:85a3:0:0:8A2E:0370:7334" "IPv6" "256.256.256.256" "Neither" 172.16.254.01 Neither 2001:0db8:85a3:0000:0000:8a2e:0370:7334 IPv6 02001:0db8:85a3:0000:0000:8a2e:0370:7334 Neither "2001:0db8:85a3:0:0:8A2E:0370:7334:" Neither "1.1.1.1." Neither "1081:db8:85a3:01:-0:8A2E:0370:7334" Neither
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String IP = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: IP = %s",
                new Solution().validIPAddress(IP), expected, IP));
        }
    }
}
