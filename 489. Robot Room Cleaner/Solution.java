class Solution {

    public void cleanRoom(Robot robot) {
        robot.clean();
    }

    public static void main(String... args) {
        for (var i = 0; i < args.length; i += 3) {
            var robot = new Robot(intArrArr(args[i]), Integer.parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
            String row = args[i + 1], col = args[i + 2];
            new Solution().cleanRoom(robot);
            System.out.println(String.format(
                "Output: %s | Input: room = %s, row = %s, col = %s",
                string(robot.room), args[i], row, col));
        }
    }

    // java Solution.java "[[1,1,1,1,1,0,1,1],[1,1,1,1,1,0,1,1],[1,0,1,1,1,1,1,1],[0,0,0,1,0,0,0,0],[1,1,1,1,1,1,1,1]]" 1 3
    private static int[][] intArrArr(String s) {
        s = s.replace(" ", "");
        if (s.equals("[[]]")) return new int[0][0];
        var rows = s.substring(1, s.length() - 1).split("\\],\\[");
        var arr = new int[rows.length][];
        for (var i = 0; i < arr.length; i++) {
            var row = rows[i].replace("[", "").replace("]", "");
            if (row.isEmpty()) {
                arr[i] = new int[0];
                continue;
            }
            var els = row.split(",");
            arr[i] = new int[els.length];
            for (var j = 0; j < arr[i].length; j++) arr[i][j] = Integer.parseInt(els[j]);
        }
        return arr;
    }

    private static String string(int[][] arr) {
        String s = "";
        for (int[] row : arr) {
            String r = "";
            for (int n : row) r += "," + n;
            if (row.length > 0) r = r.substring(1);
            s += ",[" + r + "]";
        }
        if (arr.length > 0) s = s.substring(1);
        return "[" + s + "]";
    }

}

// ~~~
class Robot {

    enum Direction { UP, RIGHT, DOWN, LEFT }

    final int[][] room;
    final int row, col;

    private int i, j;
    private Direction d = Direction.UP;

    Robot(int[][] room, int row, int col) {
        this.room = room;
        this.row = row;
        this.col = col;
        this.i = row;
        this.j = col;
    }

    boolean move() {
        if (!canMove()) {
            return false;
        }
        switch (d) {
            case UP:
                i--;
                break;
            case RIGHT:
                j++;
                break;
            case DOWN:
                i++;
                break;
            case LEFT:
                j--;
                break;
        }
        return true;
    }

    private boolean canMove() {
        switch (d) {
            case UP: return i > 0 && room[i - 1][j] != 0;
            case RIGHT: return j < room[i].length - 1 && room[i][j + 1] != 0;
            case DOWN: return i < room.length && room[i + 1][j] != 0;
            case LEFT: return j > 0 && room[i][j - 1] != 0;
        }
        throw new IllegalStateException();
    }

    void turnLeft() {
        switch (d) {
            case UP:
                d = Direction.LEFT;
                break;
            case RIGHT:
                d = Direction.UP;
                break;
            case DOWN:
                d = Direction.RIGHT;
                break;
            case LEFT:
                d = Direction.DOWN;
                break;
        }
    }

    void turnRight() {
        switch (d) {
            case UP:
                d = Direction.RIGHT;
                break;
            case RIGHT:
                d = Direction.DOWN;
                break;
            case DOWN:
                d = Direction.LEFT;
                break;
            case LEFT:
                d = Direction.UP;
                break;
        }
    }

    void clean() {
        room[i][j] = 8;
    }
}
