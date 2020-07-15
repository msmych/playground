import java.util.*;
    
    public boolean isValidSudoku(char[][] board) {
        var rows = new HashMap<Integer, Set<Character>>();
        var columns = new HashMap<Integer, Set<Character>>();
        var boxes = new HashMap<Integer, Set<Character>>();
        for (var i = 0; i < board.length; i++) {
            var line = board[i];
            for (var j = 0; j < line.length; j++) {
                var c = line[j];
                if (c == '.') {
                    continue;
                }
                rows.putIfAbsent(i, new HashSet<>());
                if (rows.get(i).contains(c)) {
                    return false;
                }
                rows.get(i).add(c);
                columns.putIfAbsent(j, new HashSet<>());
                if (columns.get(j).contains(c)) {
                    return false;
                }
                columns.get(j).add(c);
                var boxIndex = getBoxIndex(i, j);
                boxes.putIfAbsent(boxIndex, new HashSet<>());
                if (boxes.get(boxIndex).contains(c)) {
                    return false;
                }
                boxes.get(boxIndex).add(c);
            }
        }
        return true;
    }

    private int getBoxIndex(int i, int j) {
        return (i - i % 3) + j / 3;
    }

    // java Solution.java "[[5,3,.,.,7,.,.,.,.],[6,.,.,1,9,5,.,.,.],[.,9,8,.,.,.,.,6,.],[8,.,.,.,6,.,.,.,3],[4,.,.,8,.,3,.,.,1],[7,.,.,.,2,.,.,.,6],[.,6,.,.,.,.,2,8,.],[.,.,.,4,1,9,.,.,5],[.,.,.,.,8,.,.,7,9]]" "true" "[[8,3,.,.,7,.,.,.,.],[6,.,.,1,9,5,.,.,.],[.,9,8,.,.,.,.,6,.],[8,.,.,.,6,.,.,.,3],[4,.,.,8,.,3,.,.,1],[7,.,.,.,2,.,.,.,6],[.,6,.,.,.,.,2,8,.],[.,.,.,4,1,9,.,.,5],[.,.,.,.,8,.,.,7,9]]" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String board = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: board = %s",
                new Solution().isValidSudoku(array(board)), expected, board));
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
