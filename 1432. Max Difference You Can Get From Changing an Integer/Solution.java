class Solution {
    public int maxDiff(int num) {
        var s = String.valueOf(num);
        var a = s.substring(0, 1);
        var diff = Integer.parseInt(s.replaceAll(a, "9")) - Integer.parseInt(s.replaceAll(a, "1"));
        if (a.equals("1") || a.equals("9")) {
            var b = "";
            for (var c : s.toCharArray()) {
                if (c != s.charAt(0) && (a.equals("1") && c != '0' || a.equals("9") && c != '9')) {
                    b = Character.toString(c);
                    break;
                }
            }
            if (b.isEmpty()) {
                return diff;
            }
            if (a.equals("9")) {
                diff += Integer.parseInt(s.replaceAll(b, "9")) - num;
            } else {
                diff += num - Integer.parseInt(s.replaceAll(b, "0"));
            }
        }
        return diff;
    }

    // java Solution.java "555" "888" "9" "8" "123456" "820000" "10000" "80000" "9288" "8700" 1101057 8808050
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().maxDiff(Integer.parseInt(num)), expected, num));
        }
    }
}
