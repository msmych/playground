package uk.matvey.play.leet0130.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var board = new char[][]{
            {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };

        new Solution().solve(board);

        assertThat(board).hasNumberOfRows(4);
        assertThat(board[0]).containsExactly('X', 'X', 'X', 'X');
        assertThat(board[1]).containsExactly('X', 'X', 'X', 'X');
        assertThat(board[2]).containsExactly('X', 'X', 'X', 'X');
        assertThat(board[3]).containsExactly('X', 'O', 'X', 'X');
    }
}
