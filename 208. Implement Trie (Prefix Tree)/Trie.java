import java.util.*;

class Trie {

    private static class Node {
        final Map<Character, Node> children = new HashMap<>();
        boolean isWord = false;
    }

    private final Node root = new Node();

    public Trie() {}
    
    public void insert(String word) {
        var node = root;
        for (var c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        var node = root;
        for (var c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        var node = root;
        for (var c : prefix.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return true;
    }
}
