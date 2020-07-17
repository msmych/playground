class Solution {

    public String countAndSay(int n) {
        var s = "1";
        for (; n > 1; n--) {
            s = spell(s);
        }
        return s;
    }

    private String spell(String s) {
        var sb = new StringBuilder();
        while (!s.isEmpty()) {
            var count = 0;
            var c = s.charAt(0);
            while (!s.isEmpty() && s.charAt(0) == c) {
                count++;
                s = s.substring(1);
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }

    // java Solution.java "1" "1" "4" "1211"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().countAndSay(Integer.parseInt(n)), expected, n));
        }
    }
}
