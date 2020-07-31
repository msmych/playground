import static java.lang.Math.*;

class Solution {

    public int climbStairs(int n) {
        double square5 = sqrt(5);
        double fibonacci = pow((1 + square5)/2, n + 1) - pow((1 - square5)/2, n + 1);
        return (int) (fibonacci / square5);
    }

    // java Solution.java "2" "2" "3" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().climbStairs(Integer.parseInt(n)), expected, n));
        }
    }
}
