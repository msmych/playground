import java.util.*;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class AutocompleteSystem {

    private static class Trie {
        int times = 0;
        Map<Character, Trie> children = new HashMap<>();
    }

    private final Trie trie = new Trie();

    private String currentInput = "";
    private Trie currentTrie = trie;

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (var i = 0; i < sentences.length; i++) {
            var sentence = sentences[i];
            var trie = this.trie;
            for (var c : sentence.toCharArray()) {
                trie.children.putIfAbsent(c, new Trie());
                trie = trie.children.get(c);
            }
            trie.times = times[i];
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            currentTrie.times++;
            currentTrie = trie;
            currentInput = "";
            return List.of();
        }
        currentTrie.children.putIfAbsent(c, new Trie());
        currentTrie = currentTrie.children.get(c);
        currentInput = currentInput + c;
        return traverse(currentTrie, currentInput).entrySet().stream()
            .sorted(comparingInt((Map.Entry<String, Integer> e) -> e.getValue()).reversed().thenComparing(Map.Entry::getKey))
            .map(Map.Entry::getKey)
            .limit(3)
            .collect(toList());
    }

    private Map<String, Integer> traverse(Trie trie, String s) {
        var sentences = new HashMap<String, Integer>();
        if (trie.times > 0) {
            sentences.put(s, trie.times);
        }
        trie.children.entrySet().stream().map(e -> traverse(e.getValue(), s + e.getKey())).forEach(sentences::putAll);
        return sentences;
    }

    public static void main(String... args) {
        var system = new AutocompleteSystem(new String[]{ "i love you", "island","ironman", "i love leetcode" }, new int[]{ 5,3,2,2 });
        System.out.println(String.format("Output: %s | Expected: %s | input: '%s'", system.input('i'), "[\"i love you\", \"island\",\"i love leetcode\"]", 'i'));
        System.out.println(String.format("Output: %s | Expected: %s | input: '%s'", system.input(' '), "[\"i love you\",\"i love leetcode\"]", 'i'));
        System.out.println(String.format("Output: %s | Expected: %s | input: '%s'", system.input('a'), "[]", 'i'));
        System.out.println(String.format("Output: %s | Expected: %s | input: '%s'", system.input('#'), "[]", 'i'));
    }
}
