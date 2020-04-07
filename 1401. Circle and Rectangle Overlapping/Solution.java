import static java.lang.Math.sqrt;
import static java.lang.Math.abs;

class Solution {

    private int radius, cx, cy;

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {  
        this.radius = radius;
        this.cx = x_center;
        this.cy = y_center;
        return pointIsInCircle(x1, y1) || pointIsInCircle(x2, y2) || pointIsInCircle(x1, y2) || pointIsInCircle(x2, y1) ||
            cy >= y1 && cy <= y2 && (abs(x1 - cx) <= radius || abs(x2 - cx) <= radius) ||
            cx >= x1 && cx <= x2 && (abs(y1 - cy) <= radius || abs(y2 - cy) <= radius) ||
            cx >= x1 && cx <= x2 && cy >= y1 && cy <= y2;
    }

    private boolean pointIsInCircle(int x, int y) {
        return sqrt((x - cx) * (x - cx) + (y - cy) * (y - cy)) <= radius;
    }

    // java Solution.java "1" "0" "0" "1" "-1" "3" "1" "true" "1" "0" "0" "-1" "0" "0" "1" "true" "1" "1" "1" "-3" "-3" "3" "3" "true" "1" "1" "1" "1" "-3" "2" "-1" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 8) {
            String radius = args[i], x_center = args[i + 1], y_center = args[i + 2], x1 = args[i + 3], y1 = args[i + 4], x2 = args[i + 5], y2 = args[i + 6], expected = args[i + 7];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: radius = %s, x_center = %s, y_center = %s, x1 = %s, y1 = %s, x2 = %s, y2 = %s",
                new Solution().checkOverlap(Integer.parseInt(radius), Integer.parseInt(x_center), Integer.parseInt(y_center), Integer.parseInt(x1), Integer.parseInt(y1), Integer.parseInt(x2), Integer.parseInt(y2)), expected, radius, x_center, y_center, x1, y1, x2, y2));
        }
    }
}
