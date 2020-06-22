import static java.lang.Math.*;

class Solution {

    public int maxArea(int[] height) {
        var maxArea = 0;
        for (var i = 0; i < height.length - 1; i++) {
            for (var j = i + 1; j < height.length; j++) {
                var area = (j - i) * min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    // java Solution.java "[1,8,6,2,5,4,8,3,7]" "49"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String height = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: height = %s",
                new Solution().maxArea(array(height)), expected, height));
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
