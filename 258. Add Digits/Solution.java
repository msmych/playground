class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        var sum = 0;
        for (; num > 0; num /= 10) {
            sum += num % 10;
        }
        return addDigits(sum);
    }

    // java Solution.java "38" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().addDigits(Integer.parseInt(num)), expected, num));
        }
    }
}
