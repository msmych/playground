import java.util.*;

class Solution {

    private final Map<String, Boolean> cache = new HashMap<>();
    private final Set<String> dict = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return nextBreak(s);
    }

    private boolean nextBreak(String s) {
        if (s.isEmpty()) {
            return true;
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (dict.contains(s)) {
            return true;
        }
        var breaks = dict.stream()
            .filter(s::startsWith)
            .map(String::length)
            .map(s::substring)
            .anyMatch(this::nextBreak);
        cache.put(s, breaks);
        return breaks;
    }

    // java Solution.java "leetcode" "[leet,code]" "true" "applepenapple" "[apple,pen]" "true" "catsandog" "[cats,dog,sand,and,cat]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], wordDict = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, wordDict = %s",
                new Solution().wordBreak(s, stringList(wordDict)), expected, s, wordDict));
        }
    }

    private static List<String> stringList(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new ArrayList<>();
        var els = s.split(",");
        var list = new ArrayList<String>();
        for (var el : els) list.add(el);
        return list;
    }
}
