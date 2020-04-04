class Solution {
    public int bulbSwitch(int n) {
        var i = 0;
        for (var sum = 0; sum < n; i++) {
            sum += 2 * i + 3;
        }
        return i;
    }

    // java Solution.java "3" "1" 1 1 2 1 4 2 100 10
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().bulbSwitch(Integer.parseInt(n)), expected, n));
        }
    }
}
