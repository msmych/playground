import java.util.*;

class Solution {

    public int largestRectangleArea(int[] heights) {
        var stack = new Stack<Integer>();
        var max = 0;
        for (var i = 0; i <= heights.length; i++) {
            var last = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > last) {
                var height = heights[stack.pop()];
                var width = stack.isEmpty() ? i : i - stack.peek() - 1;
                var area = height * width;
                if (area > max) {
                    max = area;
                }
            }
            stack.push(i);
        }
        return max;
    }

    // java Solution.java "[2,1,5,6,2,3]" "10"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String heights = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: heights = %s",
                new Solution().largestRectangleArea(intArr(heights)), expected, heights));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
