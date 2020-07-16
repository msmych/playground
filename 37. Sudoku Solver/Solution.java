import java.util.*;

class Solution {

    public void solveSudoku(char[][] board) {
        List<List<Character>> rows = getRows(board), columns = getColumns(board), boxes = getBoxes(board);
        int blanks = countBlanks(board), lastBlanks = blanks + 1;
        while (blanks > 0) {
            if (blanks == lastBlanks) {
                int[] rowBlanks = getMinBlanksWithPosition(rows), columnBlanks = getMinBlanksWithPosition(columns), boxBlanks = getMinBlanksWithPosition(boxes);
                if (isMinimumBlanks(rowBlanks, columnBlanks, boxBlanks)) {
                    guess(board, rowBlanks[1], rowBlanks[2]);
                } else if (isMinimumBlanks(columnBlanks, rowBlanks, boxBlanks)) {
                    guess(board, columnBlanks[2], columnBlanks[1]);
                } else {
                    guess(board, getRowByBox(boxBlanks[1], boxBlanks[2]), getColumnByBox(boxBlanks[1], boxBlanks[2]));
                }
                return;
            }
            lastBlanks = blanks;
            for (var i = 0; i < board.length; i++) {
                for (var j = 0; j < board.length; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    var usedValues = new HashSet<Character>();
                    usedValues.addAll(rows.get(i));
                    usedValues.addAll(columns.get(j));
                    var boxIndex = getBoxIndex(i, j);
                    usedValues.addAll(boxes.get(boxIndex));
                    if (usedValues.size() == 9) {
                        var c = getOptions(usedValues).iterator().next();
                        board[i][j] = c;
                        rows.get(i).set(j, c);
                        columns.get(j).set(i, c);
                        boxes.get(boxIndex).set(getInnerBoxIndex(i, j), c);
                        blanks--;
                        if (hasContradiction(rows, columns, boxes)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    private List<List<Character>> getRows(char[][] board) {
        var rows = new ArrayList<List<Character>>();
        for (var row : board) {
            var cells = new ArrayList<Character>();
            for (var cell : row) {
                cells.add(cell);
            }
            rows.add(cells);
        }
        return rows;
    }

    private List<List<Character>> getColumns(char[][] board) {
        var columns = new ArrayList<List<Character>>();
        for (var row : board) {
            for (var j = 0; j < board.length; j++) {
                if (columns.size() <= j) {
                    columns.add(new ArrayList<>());
                }
                columns.get(j).add(row[j]);
            }
        }
        return columns;
    }

    private List<List<Character>> getBoxes(char[][] board) {
        var boxes = new ArrayList<List<Character>>();
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board.length; j++) {
                var boxIndex = getBoxIndex(i, j);
                if (boxes.size() <= boxIndex) {
                    boxes.add(new ArrayList<>());
                }
                boxes.get(boxIndex).add(board[i][j]);
            }
        }
        return boxes;
    }

    private int getBoxIndex(int i, int j) {
        return i - i % 3 + j / 3;
    }

    private int getInnerBoxIndex(int i, int j) {
        return 3 * (i % 3) + j % 3;
    }

    private int getRowByBox(int b, int bb) {
        return 3 * (b / 3) + bb / 3;
    }

    private int getColumnByBox(int b, int bb) {
        return 3 * (b % 3) + bb % 3;
    }

    private int countBlanks(char[][] board) {
        var blanks = 0;
        for (var row : board) {
            for (var cell : row) {
                if (cell == '.') {
                    blanks++;
                }
            }
        }
        return blanks;
    }

    private int[] getMinBlanksWithPosition(List<List<Character>> board) {
        int minBlanks = 10, posi = -1, posj = -1;
        for (int i = 0; i < board.size(); i++) {
            int blanks = 0, blankj = -1;
            for (int j = 0; j < board.size(); j++) {
                if (board.get(i).get(j) == '.') {
                    blanks++;
                    blankj = j;
                }
            }
            if (blanks > 0 && blanks < minBlanks) {
                minBlanks = blanks;
                posi = i;
                posj = blankj;
            }
        }
        return new int[]{minBlanks, posi, posj};
    }

    private boolean isMinimumBlanks(int[] min, int[] min1, int[] min2) {
        return min[0] < min1[0] && min[0] < min2[0];
    }

    private Set<Character> getOptions(Set<Character> usedNumbers) {
        Set<Character> options = new HashSet<>();
        for (int n = 1; n <= 9; n++) {
            char c = Character.forDigit(n, 10);
            if (!usedNumbers.contains(c))
                options.add(c);
        }
        return options;
    }

    private boolean hasContradiction(List<List<Character>> rows,
                                     List<List<Character>> columns,
                                     List<List<Character>> boxes) {
        int[] rowBlanks = getMinBlanksWithPosition(rows),
                columnBlanks = getMinBlanksWithPosition(columns),
                boxBlanks = getMinBlanksWithPosition(boxes);
        if (rowBlanks[0] == 1) {
            char c = getOptions(new HashSet<>(rows.get(rowBlanks[1]))).iterator().next();
            if (columns.get(rowBlanks[2]).contains(c)
                    || boxes.get(getBoxIndex(rowBlanks[1], rowBlanks[2])).contains(c))
                return true;
        }
        if (columnBlanks[0] == 1) {
            char c = getOptions(new HashSet<>(columns.get(columnBlanks[1]))).iterator().next();
            if (rows.get(columnBlanks[2]).contains(c)
                    || boxes.get(getBoxIndex(columnBlanks[2], columnBlanks[1])).contains(c))
                return true;
        }
        if (boxBlanks[0] == 1) {
            char c = getOptions(new HashSet<>(boxes.get(boxBlanks[1]))).iterator().next();
            if (rows.get(getRowByBox(boxBlanks[1], boxBlanks[2])).contains(c)
                    || columns.get(getColumnByBox(boxBlanks[1], boxBlanks[2])).contains(c))
                return true;
        }
        return false;
    }

    private void guess(char[][] board, int i, int j) {
        Set<Character> usedNumbers = new HashSet<>();
        for (int k = 0; k < board.length; k++) {
            usedNumbers.add(board[i][k]);
            usedNumbers.add(board[k][j]);
            usedNumbers.add(board[i - i % 3 + k / 3][j - j % 3 + k % 3]);
        }
        Set<Character> options = getOptions(usedNumbers);
        if (options.isEmpty())
            return;
        Iterator<Character> optionsIterator = options.iterator();
        char[][] guessBoard = new char[board.length][board.length];
        do {
            for (int x = 0; x < board.length; x++)
                System.arraycopy(board[x], 0, guessBoard[x], 0, board.length);
            guessBoard[i][j] = optionsIterator.next();
            solveSudoku(guessBoard);
        } while (countBlanks(guessBoard) > 0 && optionsIterator.hasNext());
        if (countBlanks(guessBoard) == 0)
            System.arraycopy(guessBoard, 0, board, 0, board.length);
    }

    // java Solution.java "[[5,3,.,.,7,.,.,.,.],[6,.,.,1,9,5,.,.,.],[.,9,8,.,.,.,.,6,.],[8,.,.,.,6,.,.,.,3],[4,.,.,8,.,3,.,.,1],[7,.,.,.,2,.,.,.,6],[.,6,.,.,.,.,2,8,.],[.,.,.,4,1,9,.,.,5],[.,.,.,.,8,.,.,7,9]]" "[[5,3,4,6,7,8,9,1,2],[6,7,2,1,9,5,3,4,8],[1,9,8,3,4,2,5,6,7],[8,5,9,7,6,1,4,2,3],[4,2,6,8,5,3,7,9,1],[7,1,3,9,2,4,8,5,6],[9,6,1,5,3,7,2,8,4],[2,8,7,4,1,9,6,3,5],[3,4,5,2,8,6,1,7,9]]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            var board = array(args[i]);
            var expected = args[i + 1];
            new Solution().solveSudoku(board);
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: board = %s",
                string(board), expected, args[i]));
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
