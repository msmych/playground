class Solution {
    public int minFlips(String target) {
        var flips = 0;
        var last = '0';
        for (var i = target.length() - 1; i >= 0; i--) {
            var c = target.charAt(i);
            if (c != last && (c == '1' || target.substring(0, i).contains("1"))) {
                flips++;
                last = c;
            }
        }
        if (flips > 0 && target.endsWith("0")) {
            flips++;
        }
        return flips;
    }

    // java Solution.java "10111" "3" "101" "3" "00000" "0" "001011101" "5" 11000 2
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String target = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: target = %s",
                new Solution().minFlips(target), expected, target));
        }
    }
}
