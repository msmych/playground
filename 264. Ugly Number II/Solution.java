class Solution {
    public int nthUglyNumber(int n) {
        return 0;
    }

    // java Solution.java "10" "12"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().nthUglyNumber(Integer.parseInt(n)), expected, n));
        }
    }
}
