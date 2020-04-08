class Solution {
    public int numSteps(String s) {
        var steps = 0;
        for (var sb = new StringBuilder(s); sb.length() > 1; steps++) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                var i = sb.length() - 1;
                for (; i >= 0 && sb.charAt(i) == '1'; i--) {
                    sb.setCharAt(i, '0');
                }
                if (i < 0) {
                    sb.insert(0, "1");
                } else {
                    sb.setCharAt(i, '1');
                }
            }
        }
        return steps;
    }

    // java Solution.java "1101" "6" "10" "1" "1" "0" "1111011110000011100000110001011011110010111001010111110001" 0
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().numSteps(s), expected, s));
        }
    }
}
