import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    private static class Node {
        final Map<Character, Node> children = new HashMap<>();
        String word;
        int index;
    }

    private final Node root = new Node();

    public List<List<Integer>> palindromePairs(String[] words) {
        for (var i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        var pairs = new ArrayList<List<Integer>>();
        for (var i = 0; i < words.length; i++) {
            pairs.addAll(find(words[i], 0, i, root));
        }
        return pairs;
    }

    private void insert(String word, int index) {
        var node = root;
        for (var c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.word = word;
        node.index = index;
    }

    private Set<List<Integer>> find(String word, int to, int j, Node node) {
        var pairs = new HashSet<List<Integer>>();
        var w = word.substring(0, word.length() - to);
        if (node.word != null && j != node.index) {
            if (w.isEmpty() || isAnagram(w)) {
                pairs.add(List.of(node.index, j));
            }
        }
        if (!w.isEmpty()) {
            var last = w.charAt(w.length() - 1);
            if (node.children.containsKey(last)) {
                pairs.addAll(find(word, to + 1, j, node.children.get(last)));
            }
        } else {
            pairs.addAll(palindromes(node, word.length()).entrySet().stream()
                    .filter(p -> p.getValue() != j)
                    .map(p -> Arrays.asList(p.getValue(), j))
                    .collect(toSet()));
        }
        return pairs;
    }

    private boolean isAnagram(String word) {
        return new StringBuffer(word).reverse().toString().equals(word);
    }

    private Map<String, Integer> palindromes(Node root, int from) {
        var palindromes = new HashMap<String, Integer>();
        if (root.word != null && isAnagram(root.word.substring(from))) {
            palindromes.put(root.word, root.index);
        }
        for (Node child : root.children.values()) {
            palindromes.putAll(palindromes(child, from));
        }
        return palindromes;
    }

    // java Solution.java "[abcd,dcba,lls,s,sssll]" "[[0,1],[1,0],[3,2],[2,4]]" "[bat,tab,cat]" "[[0,1],[1,0]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String words = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: words = %s",
                new Solution().palindromePairs(stringArr(words)), expected, words));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
