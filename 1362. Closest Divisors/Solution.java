import static java.lang.Math.sqrt;

class Solution {
    public int[] closestDivisors(int num) {
        for (int i = ((int) sqrt(num)) + 1; i > 1; i--) {
            if ((num + 1) % i == 0) {
                return new int[]{i, (num + 1) / i};
            } else if ((num + 2) % i == 0) {
                return new int[]{i, (num + 2) / i};
            }
        }
        return new int[]{1, num + 1};
    }

    // java Solution.java "8" "[3,3]" "123" "[5,25]" "999" "[40,25]" 999999999 "[31250,32000]" 2 "[2,2]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                string(new Solution().closestDivisors(Integer.parseInt(num))), expected, num));
        }
    }

    private static String string(int[] arr) {
        String s = "";
        for (int n : arr) s += "," + n;
        if (!s.isEmpty()) s = s.substring(1);
        return "[" + s + "]";
    }
}
