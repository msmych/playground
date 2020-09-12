import static java.util.Arrays.*;

class Solution {

    public int calculate(String s) {
        return stream(s.replaceAll(" ", "").split("\\+")).mapToInt(this::calcNext).sum();
    }

    private int calcNext(String s) {
        var minusIndex = s.lastIndexOf('-');
        if (minusIndex != -1 && minusIndex != 0) {
            return calcNext(s.substring(0, minusIndex)) - calcNext(s.substring(minusIndex + 1));
        }
        if (!s.contains("*") && !s.contains("/")) {
            return Integer.parseInt(s);
        }
        int timesIndex = s.lastIndexOf('*'), divideIndex = s.lastIndexOf('/');
        return timesIndex > divideIndex
            ? calcNext(s.substring(0, timesIndex)) * calcNext(s.substring(timesIndex + 1))
            : calcNext(s.substring(0, divideIndex)) / calcNext(s.substring(divideIndex + 1));
    }

    // java Solution.java "3+2*2" "7" " 3/2 " "1" " 3+5 / 2 " "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().calculate(s), expected, s));
        }
    }
}
