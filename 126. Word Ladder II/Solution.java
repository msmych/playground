import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    private final Queue<List<String>> queue = new LinkedList<>();

    private String endWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.endWord = endWord;
        queue.offer(List.of(beginWord));
        var wordOptions = new ArrayList<>(wordList);
        var allNextWords = new HashSet<String>();
        while (!wordOptions.isEmpty()) {
            if (queue.stream().anyMatch(list -> list.get(list.size() - 1).equals(endWord))) {
                return relevantLadders();
            }
            for (var size = queue.size(); size > 0; size--) {
                var words = queue.poll();
                var nextSet = wordOptions.stream()
                        .filter(word -> isOneLetterDifference(word, words.get(words.size() - 1)))
                        .collect(toSet());
                allNextWords.addAll(nextSet);
                for (String next : nextSet) {
                    var list = new ArrayList<>(words);
                    list.add(next);
                    queue.offer(list);
                }
            }
            if (allNextWords.isEmpty()) {
                return new ArrayList<>();
            }
            wordOptions.removeAll(allNextWords);
        }
        if (queue.stream().noneMatch(words -> words.get(words.size() - 1).equals(endWord))) {
            return new ArrayList<>();
        }
        return relevantLadders();
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

    private List<List<String>> relevantLadders() {
        return queue.stream()
                .filter(list -> list.get(list.size() - 1).equals(endWord))
                .collect(toList());
    }

    // java Solution.java "hit" "cog" "[hot,dot,dog,lot,log,cog]" "[[hit,hot,dot,dog,cog],[hit,hot,lot,log,cog]]" "hit" "cog" "[hot,dot,dog,lot,log]" "[]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String beginWord = args[i], endWord = args[i + 1], wordList = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: beginWord = %s, endWord = %s, wordList = %s",
                new Solution().findLadders(beginWord, endWord, stringList(wordList)), expected, beginWord, endWord, wordList));
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
