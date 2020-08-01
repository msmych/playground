class Solution {

    public boolean detectCapitalUse(String word) {
        return word.equals(word.toUpperCase()) ||
                word.equals(word.toLowerCase()) ||
                word.equals(word.substring(0, 1).toUpperCase() + word.toLowerCase().substring(1));
    }

    // java Solution.java "USA" "true" "FlaG" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String word = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: word = %s",
                new Solution().detectCapitalUse(word), expected, word));
        }
    }
}
