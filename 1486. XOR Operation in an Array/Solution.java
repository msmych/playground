import static java.util.stream.IntStream.*;

class Solution {
    public int xorOperation(int n, int start) {
        return range(0, n)
            .map(i -> start + 2 * i)
            .reduce((a, b) -> a ^ b)
            .getAsInt();
    }

    // java Solution.java "5" "0" "8" "4" "3" "8" "1" "7" "7" "10" "5" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], start = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, start = %s",
                new Solution().xorOperation(Integer.parseInt(n), Integer.parseInt(start)), expected, n, start));
        }
    }
}
