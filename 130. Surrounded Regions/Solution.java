import java.util.*;

class Solution {

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

    private Set<Point> visited = new HashSet<>();
    private Set<Point> surrounded = new HashSet<>();

    private char[][] board;

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        this.board = board;
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                visited = new HashSet<>();
                surrounded = new HashSet<>();
                if (board[i][j] == 'O' && nextSurrounded(i, j)) {
                    surrounded.forEach(p -> board[p.i][p.j] = 'X');
                }
            }
        }
    }

    private boolean nextSurrounded(int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == 'X') {
            return true;
        }
        visited.add(new Point(i, j));
        var isSurrounded = true;
        if (!visited.contains(new Point(i, j + 1))) {
            isSurrounded = nextSurrounded(i, j + 1);
        }
        if (isSurrounded && !visited.contains(new Point(i, j - 1))) {
            isSurrounded = nextSurrounded(i, j - 1);
        }
        if (isSurrounded && !visited.contains(new Point(i + 1, j))) {
            isSurrounded = nextSurrounded(i + 1, j);
        }
        if (isSurrounded && !visited.contains(new Point(i - 1, j))) {
            isSurrounded = nextSurrounded(i - 1, j);
        }
        if (isSurrounded) {
            surrounded.add(new Point(i, j));
        }
        return isSurrounded;
    }

    // java Solution.java "[[X,X,X,X],[X,O,O,X],[X,X,O,X],[X,O,X,X]]" "[[X,X,X,X],[X,X,X,X],[X,X,X,X],[X,O,X,X]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var board = charArrArr(args[i]);
            String expected = args[i + 1];
            new Solution().solve(board);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: board = %s",
                string(board), expected, args[i]));
        }
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

    private static String string(char[][] arr) {
        var s = "";
        for (var row : arr) {
            var r = "";
            for (var c : row) r += "," + c;
            if (row.length > 0) r = r.substring(1);
            s += ",[" + r + "]";
        }
        if (arr.length > 0) s = s.substring(1);
        return "[" + s + "]";
    }
}
