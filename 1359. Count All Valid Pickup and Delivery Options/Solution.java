class Solution {
    public int countOrders(int n) {
        int mod = 1_000_000_007;
        long orders = 1;
        for (int i = 1; i <= n; i++) {
            orders = orders * (2 * i - 1) * i % mod;
        }
        return (int) orders;
    }

    // java Solution.java "1" "1" "2" "6" "3" "90" 444 693487723
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().countOrders(Integer.parseInt(n)), expected, n));
        }
    }
}
