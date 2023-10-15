package uk.matvey.play.leet1041.java1;

public class Solution {
    private int x, y, d;

    public boolean isRobotBounded(String instructions) {
        if (!instructions.contains("L") && !instructions.contains("R")) {
            return false;
        }
        for (var j = 0; j < instructions.length(); j++) {
            move(instructions.charAt(j));
        }
        return d != 0 || x == 0 && y == 0;
    }

    private void move(char instruction) {
        switch (instruction) {
            case 'L':
                d = d == 0 ? 3 : d - 1;
                break;
            case 'R':
                d = (d + 1) % 4;
                break;
            case 'G':
                go();
        }
    }

    private void go() {
        switch (d) {
            case 0:
                y++;
                break;
            case 1:
                x++;
                break;
            case 2:
                y--;
                break;
            case 3:
                x--;
        }
    }
}
