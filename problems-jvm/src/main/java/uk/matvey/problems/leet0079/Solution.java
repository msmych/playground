package uk.matvey.problems.leet0079;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private record Letter(
        char c,
        int i,
        int j) {
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
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
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
        char c = board[i][j];
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
}

class SolutionTest {

    @Test
    void case1() {
        var board = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        final var result = new Solution().exist(board, "ABCCED");

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        var board = new char[][]{
            {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };

        final var result = new Solution().exist(board, "SEE");

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        var board = new char[][]{
            {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };

        final var result = new Solution().exist(board, "ABCB");

        assertThat(result).isFalse();
    }
}