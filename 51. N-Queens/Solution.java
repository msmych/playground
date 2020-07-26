import java.util.*;

class Solution {

    private static class Cell {
        int i, j;

        Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return i == cell.i &&
                    j == cell.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private int size;

    public List<List<String>> solveNQueens(int n) {
        this.size = n;
        var boards = new ArrayList<List<String>>();
        for (var queens : solveNext(n, new HashSet<>(), new HashSet<>())) {
            var board = new ArrayList<String>();
            for (var i = 0; i < size; i++) {
                var sb = new StringBuilder();
                for (var j = 0; j < size; j++) {
                    sb.append(queens.contains(new Cell(i, j)) ? 'Q' : '.');
                }
                board.add(sb.toString());
            }
            boards.add(board);
        }
        return boards;
    }

    private Set<Set<Cell>> solveNext(int n, Set<Cell> lastQueens, Set<Cell> lastOccupied) {
        var queens = new HashSet<Set<Cell>>();
        if (n == 0) {
            queens.add(lastQueens);
            return queens;
        }
        if (size * size - lastOccupied.size() < n) {
            return new HashSet<>();
        }
        var i = size - n;
        for (var j = 0; j < size; j++) {
            var queen = new Cell(i, j);
            if (lastOccupied.contains(queen)) {
                continue;
            }
            var nextQueens = new HashSet<>(lastQueens);
            nextQueens.add(queen);
            var nextOccupied = new HashSet<>(lastOccupied);
            nextOccupied.addAll(getOccupiedRow(i));
            nextOccupied.addAll(getOccupiedColumn(j));
            nextOccupied.addAll(getOccupiedDownDiagonal(i, j));
            nextOccupied.addAll(getOccupiedUpDiagonal(i, j));
            queens.addAll(solveNext(n - 1, nextQueens, nextOccupied));
        }
        return queens;
    }

    private Set<Cell> getOccupiedRow(int i) {
        var row = new HashSet<Cell>();
        for (var j = 0; j < size; j++) {
            row.add(new Cell(i, j));
        }
        return row;
    }

    private Set<Cell> getOccupiedColumn(int j) {
        var column = new HashSet<Cell>();
        for (var i = 0; i < size; i++) {
            column.add(new Cell(i, j));
        }
        return column;
    }

    private Set<Cell> getOccupiedDownDiagonal(int i, int j) {
        var diagonal = new HashSet<Cell>();
        int x = i, y = j;
        while (--x >= 0 && --y >= 0) {
            diagonal.add(new Cell(x, y));
        }
        x = i;
        y = j;
        while (++x < size && ++y < size) {
            diagonal.add(new Cell(x, y));
        }
        return diagonal;
    }

    private Set<Cell> getOccupiedUpDiagonal(int i, int j) {
        var diagonal = new HashSet<Cell>();
        int x = i, y = j;
        while (--x >= 0 && ++y < size) {
            diagonal.add(new Cell(x, y));
        }
        x = i;
        y = j;
        while (++x < size && --y >= 0) {
            diagonal.add(new Cell(x, y));
        }
        return diagonal;
    }

    // java Solution.java "4" "[[.Q..,...Q,Q...,..Q.],[..Q.,Q...,...Q,.Q..]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().solveNQueens(Integer.parseInt(n)), expected, n));
        }
    }
}
