class Solution {

    public int hammingWeight(int n) {
        var ones = 0;
        while (n != 0) {
            ones++;
            n &= (n - 1);
        }
        return ones;
    }

    // java Solution.java "11" "3" "128" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().hammingWeight(Integer.parseInt(n)), expected, n));
        }
    }
}
