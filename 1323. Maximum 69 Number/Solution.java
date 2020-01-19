class Solution {
    public int maximum69Number (int num) {
        return Integer.parseInt(Integer.toString(num).replaceFirst("6", "9"));
    }

    // java Solution.java "9669" "9969" "9996" "9999" "9999" "9999"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            Solution solution = new Solution();
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                solution.maximum69Number(Integer.parseInt(num)), expected, num));
        }
    }
}
