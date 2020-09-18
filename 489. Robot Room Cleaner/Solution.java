class Solution {

    public void cleanRoom(Robot robot) {
    }

    public static void main(String... args) {
        for (var i = 0; i < args.length; i += 3) {
            var robot = new Robot(intArrArr(args[i]), Integer.parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
            String row = args[i + 1], col = args[i + 2];
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

class Robot {

    final int[][] room;
    final int row, col;

    Robot(int[][] room, int row, int col) {
        this.room = room;
        this.row = row;
        this.col = col;
    }

    boolean move() {
        return false;
    }

    void turnLeft() {
    }

    void turnRight() {
    }

    void clean() {
    }
}
