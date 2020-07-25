class Solution {
    public int countOdds(int low, int high) {
        int left = low % 2 == 1 ? low : low + 1, right = high % 2 == 1 ? high : high - 1;
        return (right - left) / 2 + 1;
    }

    // java Solution.java "3" "7" "3" "8" "10" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String low = args[i], high = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: low = %s, high = %s",
                new Solution().countOdds(Integer.parseInt(low), Integer.parseInt(high)), expected, low, high));
        }
    }
}
