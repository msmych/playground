import java.util.*;

class Solution {

    private static class Letter {
        char c;
        int i, j;

        Letter(char c, int i, int j) {
            this.c = c;
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Letter letter = (Letter) o;
            return c == letter.c &&
                i == letter.i &&
                j == letter.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, i, j);
        }
    }

    private final Set<Letter> visited = new HashSet<>();

    private char[][] board;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        this.board = board;
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (existsNext(word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existsNext(String word, int i, int j) {
        if (word.isEmpty()) {
            return true;
        }
        var c = board[i][j];
        var letter = new Letter(c, i, j);
        if (c != word.charAt(0)) {
            return false;
        }
        if (visited.contains(letter)) {
            return false;
        }
        visited.add(letter);
        var next = word.substring(1);
        if (next.isEmpty()) {
            return true;
        }
        if (j > 0 && existsNext(next, i, j - 1)) {
            return true;
        }
        if (i > 0 && existsNext(next, i - 1, j)) {
            return true;
        }
        if (j < board[0].length - 1 && existsNext(next, i, j + 1)) {
            return true;
        }
        if (i < board.length - 1 && existsNext(next, i + 1, j)) {
            return true;
        }
        visited.remove(letter);
        return false;
    }

    // java Solution.java "[[A,B,C,E],[S,F,C,S],[A,D,E,E]]" "ABCCED" "true" "[[A,B,C,E],[S,F,C,S],[A,D,E,E]]" "SEE" "true" "[[A,B,C,E],[S,F,C,S],[A,D,E,E]]" "ABCB" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String board = args[i], word = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: board = %s, word = %s",
                new Solution().exist(array(board), word), expected, board, word));
        }
    }

    private static char[][] array(String s) {
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
