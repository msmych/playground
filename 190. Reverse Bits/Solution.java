class Solution {
    public int reverseBits(int n) {
        var reversed = 0;
        for (var i = 0; i < 32; i++) {
            reversed <<= 1;
            reversed |= n & 1;
            n >>= 1;
        }
        return reversed;
    }

    // java Solution.java "00000010100101000001111010011100" "00111001011110000010100101000000" "11111111111111111111111111111101" "10111111111111111111111111111111"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().reverseBits((int) Long.parseLong(n, 2)), expected, n));
        }
    }
}
