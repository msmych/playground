import static java.util.Arrays.*;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        sort(horizontalCuts);
        sort(verticalCuts);
        return (int) ((max(h, horizontalCuts) * max(w, verticalCuts)) % 1_000_000_007);
    }

    private long max(int n, int[] cuts) {
        if (cuts.length == 0) {
            return (long) n;
        }
        long max = cuts[0];
        for (var i = 1; i < cuts.length; i++) {
            if (cuts[i] - cuts[i - 1] > max) {
                max = (long) cuts[i] - cuts[i - 1];
            }
        }
        if (n - cuts[cuts.length - 1] > max) {
            max = (long) n - cuts[cuts.length - 1];
        }
        return max;
    }

    // java Solution.java "5" "4" "[1,2,4]" "[1,3]" "4" "5" "4" "[3,1]" "[1]" "6" "5" "4" "[3]" "[3]" "9"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 5) {
            String h = args[i], w = args[i + 1], horizontalCuts = args[i + 2], verticalCuts = args[i + 3], expected = args[i + 4];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: h = %s, w = %s, horizontalCuts = %s, verticalCuts = %s",
                new Solution().maxArea(Integer.parseInt(h), Integer.parseInt(w), array(horizontalCuts), array(verticalCuts)), expected, h, w, horizontalCuts, verticalCuts));
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
