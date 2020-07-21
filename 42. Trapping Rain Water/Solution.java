import java.util.*;

class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        var water = 0;
        var levels = new Stack<int[]>();
        levels.push(new int[]{0, height[0]});
        var lastLevel = height[0];
        for (var i = 1; i < height.length; i++) {
            if (height[i] > lastLevel && !levels.isEmpty()) {
                int[] level;
                while (!levels.isEmpty()) {
                    level = levels.peek();
                    water += (i - level[0] - 1) * (Math.min(height[i], level[1]) - lastLevel);
                    if (height[i] > level[1]) {
                        levels.pop();
                        lastLevel = level[1];
                    } else {
                        levels.push(new int[]{i, height[i]});
                        break;
                    }
                }
                if (levels.isEmpty()) {
                    levels.push(new int[]{i, height[i]});
                }
            } else {
                levels.push(new int[]{i, height[i]});
                lastLevel = height[i];
            }
        }
        return water;
    }

    // java Solution.java "[0,1,0,2,1,0,1,3,2,1,2,1]" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String height = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: height = %s",
                new Solution().trap(array(height)), expected, height));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
