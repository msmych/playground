class Solution {
    public int kthFactor(int n, int k) {
        for (var i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
            }
            if (k == 0) {
                return i;
            }
        }
        return -1;
    }

    // java Solution.java "12" "3" "3" "7" "2" "7" "4" "4" "-1" "1" "1" "1" "1000" "3" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, k = %s",
                new Solution().kthFactor(Integer.parseInt(n), Integer.parseInt(k)), expected, n, k));
        }
    }
}
