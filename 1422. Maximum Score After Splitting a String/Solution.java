class Solution {
    public int maxScore(String s) {
        var ones = new int[s.length() + 1];
        for (var i = 0; i < s.length(); i++) {
            ones[i + 1] = s.charAt(i) == '1' ? ones[i] + 1 : ones[i];
        }
        var zeroes = 0;
        var max = 0;
        for (var i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroes++;
            }
            var score = zeroes + ones[ones.length - 1] - ones[i + 1];
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    // java Solution.java "011101" "5" "00111" "5" "1111" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().maxScore(s), expected, s));
        }
    }
}
