class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && Integer.toString(num, 4).matches("^10*$");
    }

    // java Solution.java "16" "true" "5" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().isPowerOfFour(Integer.parseInt(num)), expected, num));
        }
    }
}
