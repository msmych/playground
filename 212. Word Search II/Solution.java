import java.util.*;

import static java.util.Arrays.*;

class Solution {

    private static class Node {
        final Map<Character, Node> children = new HashMap<>();
        String word = "";
    }

    private static class Point {
        int i, j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i &&
                j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private final Node root = new Node();
    private final Set<Point> visited = new HashSet<>();
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        var found = new ArrayList<String>();
        if (board.length == 0) {
            return found;
        }
        stream(words).forEach(this::insert);
        var foundSet = new HashSet<String>();
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                foundSet.addAll(find(i, j, root));
            }
        }
        found.addAll(foundSet);
        return found;
    }

    private void insert(String word) {
        var node = root;
        for (var c : word.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
        }
        node.word = word;
    }

    private Set<String> find(int i, int j, Node node) {
        if (node == null) {
            return Set.of();
        }
        var found = new HashSet<String>();
        if (!node.word.isEmpty()) {
            found.add(node.word);
        }
        var point = new Point(i, j);
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited.contains(point)) {
            return found;
        }
        var c = board[i][j];
        if (!node.children.containsKey(c)) {
            return found;
        }
        visited.add(point);
        var next = node.children.get(c);
        found.addAll(find(i + 1, j, next));
        found.addAll(find(i - 1, j, next));
        found.addAll(find(i, j + 1, next));
        found.addAll(find(i, j - 1, next));
        visited.remove(point);
        return found;
    }

    // java Solution.java "[[o,a,a,n],[e,t,a,e],[i,h,k,r],[i,f,l,v]]" "[oath,pea,eat,rain]" "[eat,oath]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String board = args[i], words = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: board = %s, words = %s",
                new Solution().findWords(charArrArr(board), stringArr(words)), expected, board, words));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }

    private static char[][] charArrArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new char[0][0];
        String[] rows = s.substring(1, s.length() - 1).split("\\],\\[");
        if (rows[0].isEmpty()) return new char[0][0];
        char[][] arr = new char[rows.length][rows[0].split(",").length];
        for (int i = 0; i < arr.length; i++) {
            String[] elements = rows[i].split(",");
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = elements[j].charAt(0);
        }
        return arr;
    }
}
