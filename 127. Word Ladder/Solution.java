import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var steps = 0;
        var queue = new LinkedList<String>();
        queue.offer(beginWord);
        var wordOptions = new ArrayList<>(wordList);
        while (!wordOptions.isEmpty()) {
            for (var size = queue.size(); size > 0; size--) {
                var word = queue.poll();
                if (word.equals(endWord)) {
                    return steps + 1;
                }
                var nextSet = wordOptions.stream()
                    .filter(w -> isOneLetterDifference(w, word))
                    .collect(toSet());
                if (nextSet.isEmpty() && queue.isEmpty()) {
                    return 0;
                }
                wordOptions.removeAll(nextSet);
                for (var next : nextSet) {
                    queue.offer(next);
                }
            }
            steps++;
        }
        return queue.contains(endWord) ? steps + 1 : 0;
    }

    private boolean isOneLetterDifference(String w1, String w2) {
        var diff = 0;
        for (var i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    // java Solution.java "hit" "cog" "[hot,dot,dog,lot,log,cog]" "5" "hit" "cog" "[hot,dot,dog,lot,log]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String beginWord = args[i], endWord = args[i + 1], wordList = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: beginWord = %s, endWord = %s, wordList = %s",
                new Solution().ladderLength(beginWord, endWord, stringList(wordList)), expected, beginWord, endWord, wordList));
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
