class Solution {
    public int minimumDistance(String word) {
        return 0;
    }

    // java Solution.java "CAKE" "3" "HAPPY" "6" "NEW" "3" "YEAR" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            Solution solution = new Solution();
            String word = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: word = %s",
                solution.minimumDistance(word), expected, word));
        }
    }
}
