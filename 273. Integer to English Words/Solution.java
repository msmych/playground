class Solution {
    public String numberToWords(int num) {
        return "";
    }

    // java Solution.java "123" "One Hundred Twenty Three" "12345" "Twelve Thousand Three Hundred Forty Five" "1234567" "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" "1234567891" "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().numberToWords(Integer.parseInt(num)), expected, num));
        }
    }
}
