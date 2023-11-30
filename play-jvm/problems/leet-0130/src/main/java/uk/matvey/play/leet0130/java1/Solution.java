package uk.matvey.play.leet0130.java1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
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
}
