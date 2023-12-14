package uk.matvey.play.leet1349.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var seats = new char[][]{{'#', '.', '#', '#', '.', '#'}, {'.', '#', '#', '#', '#', '.'}, {'#', '.', '#', '#', '.', '#'}};

        int result = new Solution().maxStudents(seats);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var seats = new char[][]{{'.', '#'}, {'#', '#'}, {'#', '.'}, {'#', '#'}, {'.', '#'}};

        int result = new Solution().maxStudents(seats);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        var seats = new char[][]{{'#', '.', '.', '.', '#'}, {'.', '#', '.', '#', '.'}, {'.', '.', '#', '.', '.'}, {'.', '#', '.', '#', '.'}, {'#', '.', '.', '.', '#'}};

        int result = new Solution().maxStudents(seats);

        assertThat(result).isEqualTo(10);
    }
}
