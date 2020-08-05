import java.util.*;

class WordDictionary {

    private static class Node {
        final Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    private final Node root = new Node();

    public void addWord(String word) {
        var node = root;
        for (var c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return isPresent(word, root);
    }

    private boolean isPresent(String word, Node node) {
        for (var i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            if (c == '.') {
                return node.children.values().stream()
                        .anyMatch(n -> isPresent(word.substring(word.indexOf('.') + 1), n));
            } else {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
        }
        return node.isWord;
    }
}
