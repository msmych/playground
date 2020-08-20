class Solution {

    public int minOperations(int n) {
        var even = n % 2 == 0;
        int ops = even ? 1 : 0, mid = even ? n / 2 - 1 : n / 2;
        for (var i = 0; i < mid; i++) {
            ops += even ? 1 + 2 * i + 2: 2 * i + 2;
        }
        return ops;
    }

    // java Solution.java "3" "2" "6" "9"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().minOperations(Integer.parseInt(n)), expected, n));
        }
    }
}
