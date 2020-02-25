import static java.util.Arrays.stream;

class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] letters = new int[]{-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] = i;
            count += 1 + stream(letters).min().getAsInt();
        }
        return count;
    }

    // java Solution.java "abcabc" "10" "aaacb" "3" "abc" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().numberOfSubstrings(s), expected, s));
        }
    }
}
