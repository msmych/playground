import static java.lang.Math.abs;

class Solution {
    public int minSteps(String s, String t) {
        int[] smap = occurrences(s);
        int[] tmap = occurrences(t);
        int difference = 0;
        for (int i = 0; i < 26; i++) {
            difference += abs(smap[i] - tmap[i]);
        }
        return difference % 2 == 0
            ? difference / 2
            : difference / 2 + 1;
    }

    private int[] occurrences(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }

    // java Solution.java "bab" "aba" "1" "leetcode" "practice" "5" "anagram" "mangaar" "0" "xxyyzz" "xxyyzz" "0" "friend" "family" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], t = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, t = %s",
                new Solution().minSteps(s, t), expected, s, t));
        }
    }
}
