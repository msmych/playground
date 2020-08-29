import java.util.*;

import static java.util.stream.IntStream.*;

class Solution {

    private final Map<String, Boolean> cache = new HashMap<>();
    private final Map<String, Integer> minCache = new HashMap<>();

    public int minCut(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (minCache.containsKey(s)) {
            return minCache.get(s);
        }
        if (isPalindrome(s)) {
            return 0;
        }
        for (var i = 1; i < s.length() - 1; i++) {
            if (isPalindrome(s.substring(0, i)) && isPalindrome(s.substring(i))) {
                return 1;
            }
        }
        int minCut = 1 + range(1, s.length())
                .mapToObj(i -> s.substring(0, i))
                .filter(this::isPalindrome)
                .map(String::length)
                .map(s::substring)
                .mapToInt(this::minCut)
                .min()
                .getAsInt();
        minCache.put(s, minCut);
        return minCut;
    }

    private boolean isPalindrome(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var isPalindrome = new StringBuffer(s).reverse().toString().equals(s);
        cache.put(s, isPalindrome);
        return isPalindrome;
    }

    // java Solution.java "aab" "1" "a" "0" "ab" "1"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().minCut(s), expected, s));
        }
    }
}
