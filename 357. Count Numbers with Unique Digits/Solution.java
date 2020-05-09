class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        var count = 10;
        for (int unique = 9, available = 9; n > 1 && available > 0; n--, available--) {
            unique *= available;
            count += unique;
        }
        return count;
    }

    // java Solution.java "2" "91"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().countNumbersWithUniqueDigits(Integer.parseInt(n)), expected, n));
        }
    }
}
