class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append('b');
            n--;
        }
        for (; n > 0; n--) {
            sb.append('a');
        }
        return sb.toString();
    }

    // java Solution.java "4" "pppz" "2" "xy" "7" "holasss" 32 "abcdefghijklmnopqrstuvwxyzzzzzzz" 33 "abcdefghijklmnopqrstuvwxyyyyyyyyy"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().generateTheString(Integer.parseInt(n)), expected, n));
        }
    }
}
