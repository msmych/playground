class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            var x = b;
            b = a % b;
            a = x;
        }
        return a;
    }

    // java Solution.java "3" "5" "4" "true" "2" "6" "5" "false" 0 0 0 true 0 2 1 false 1 2 3 true 2 3 5 true 2 7 9 true 34 5 6 true 13 11 1 true 23 46 23 true 22003 31237 1 true
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 4) {
            String x = args[i], y = args[i + 1], z = args[i + 2], expected = args[i + 3];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: x = %s, y = %s, z = %s",
                new Solution().canMeasureWater(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z)), expected, x, y, z));
        }
    }
}
