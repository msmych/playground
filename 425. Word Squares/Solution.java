import java.util.*;

class Solution {

    private static class Trie {
        List<Integer> words = new ArrayList<>();
        Map<Character, Trie> children = new HashMap<>();
    }

    private final Trie trie = new Trie();

    private String[] words;
    private int n;

    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.n = words[0].length();
        for (var i = 0; i < words.length; i++) {
            var word = words[i];
            var trie = this.trie;
            for (var c : word.toCharArray()) {
                trie.children.putIfAbsent(c, new Trie());
                trie = trie.children.get(c);
                trie.words.add(i);
            }
        }
        var squares = new ArrayList<List<String>>();
        for (var word : words) {
            var wordSquares = new ArrayList<String>();
            wordSquares.add(word);
            findSquares(squares, wordSquares, 1);
        }
        return squares;
    }

    private void findSquares(List<List<String>> squares, List<String> wordSquares, int i) {
        if (i == n) {
            squares.add(new ArrayList<>(wordSquares));
            return;
        }
        var prefix = new StringBuilder();
        for (var word : wordSquares) {
            prefix.append(word.charAt(i));
        }
        for (var wordIndex : wordsWithPrefixIndexes(prefix.toString())) {
            wordSquares.add(words[wordIndex]);
            findSquares(squares, wordSquares, i + 1);
            wordSquares.remove(wordSquares.size() - 1);
        }
    }

    private List<Integer> wordsWithPrefixIndexes(String prefix) {
        var trie = this.trie;
        for (var c : prefix.toCharArray()) {
            if (trie.children.containsKey(c)) {
                trie = trie.children.get(c);
            } else {
                return List.of();
            }
        }
        return trie.words;
    }

    // java Solution.java "[area,lead,wall,lady,ball]" "[[wall,area,lead,lady],[ball,area,lead,lady]]" "[abat,baba,atan,atal]" "[[baba,abat,baba,atan],[baba,abat,baba,atal]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String words = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s",
                new Solution().wordSquares(stringArr(words)), expected, words));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
