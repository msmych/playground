class Solution {
    public boolean hasAllCodes(String s, int k) {
        return false;
    }

    // java Solution.java "00110110" "2" "true" "00110" "2" "true" "0110" "1" "true" "0110" "2" "false" "0000000001011100" "4" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, k = %s",
                new Solution().hasAllCodes(s, Integer.parseInt(k)), expected, s, k));
        }
    }
}
