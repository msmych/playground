import java.util.*;

class Solution {
    public int maxVowels(String s, int k) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int max = (int) s.substring(0, k).chars()
            .mapToObj(c -> (char) c)
            .filter(vowels::contains)
            .count();
        for (int i = 0, count = max; i + k < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count--;
            }
            if (vowels.contains(s.charAt(i + k))) {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    // java Solution.java "abciiidef" "3" "3" "aeiou" "2" "2" "leetcode" "3" "2" "rhythms" "4" "0" "tryhard" "4" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, k = %s",
                new Solution().maxVowels(s, Integer.parseInt(k)), expected, s, k));
        }
    }
}
