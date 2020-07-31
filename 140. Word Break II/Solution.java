import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    private final List<String> dict = new ArrayList<>();
    private final Map<String, Set<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict.addAll(wordDict);
        return new ArrayList<>(nextBreak(s));
    }

    private Set<String> nextBreak(String s) {
        if (s.isEmpty()) {
            return new HashSet<>();
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        var phrases = dict.stream().filter(s::equals).collect(toSet());
        for (var word : dict.stream().filter(w -> !w.equals(s)).filter(s::startsWith).collect(toSet())) {
            for (var nextPhrase : nextBreak(s.substring(word.length()))) {
                phrases.add(word + " " + nextPhrase);
            }
        }
        cache.put(s, phrases);
        return phrases;
    }

    // java Solution.java "catsanddog" "[cat,cats,and,sand,dog]" "[cats and dog,cat sand dog]" "pineapplepenapple" "[apple,pen,applepen,pine,pineapple]" "[pine apple pen apple,pineapple pen apple,pine applepen apple]" "catsandog" "[cats,dog,sand,and,cat]" "[]"
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
