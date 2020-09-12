class Solution {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && 1073741824 % n == 0;
    }

    // java Solution.java "1" "true" "16" "true" "218" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().isPowerOfTwo(Integer.parseInt(n)), expected, n));
        }
    }
}
