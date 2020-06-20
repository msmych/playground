class Solution {
    public int reverse(int x) {
        int reversed = 0, MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
        while (x != 0) {
            var next = x % 10;
            x /= 10;
            if (reversed > MAX/10 || (reversed == MAX/10 && next > 7)) {
                return 0;
            }
            if (reversed < MIN/10 || (reversed == MIN/10 && next < -8)) {
                return 0;
            }
            reversed *= 10;
            reversed += next;
        }
        return reversed;
    }

    // java Solution.java "123" "321" "-123" "-321" "120" "21"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String x = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: x = %s",
                new Solution().reverse(Integer.parseInt(x)), expected, x));
        }
    }
}
