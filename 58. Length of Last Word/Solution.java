class Solution {
    public int lengthOfLastWord(String s) {
        var words = s.split(" ");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }

    // java Solution.java "Hello World" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().lengthOfLastWord(s), expected, s));
        }
    }
}
