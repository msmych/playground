class Solution {

    public String convertToTitle(int n) {
        var col = new StringBuilder();
        var range = 'Z' - 'A' + 1;
        while (n > 0) {
            col.append(Character.valueOf((char) ('A' + ((n - 1) % range))));
            if (n / range == 1 && n % range == 0) {
                break;
            }
            n = (n - 1) / range;
        }
        return col.reverse().toString();
    }

    // java Solution.java "1" "A" "28" "AB" "701" "ZY"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().convertToTitle(Integer.parseInt(n)), expected, n));
        }
    }
}
