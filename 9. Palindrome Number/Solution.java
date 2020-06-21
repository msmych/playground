class Solution {
    public boolean isPalindrome(int x) {
        int newNumber = 0;
        int div10 = x;
        if (x < 0) {
            return false;
        } else {
            do {
                int divNoReminder10 = div10 % 10;
                div10 /= 10;
                newNumber = newNumber * 10 + divNoReminder10;
            } while (div10 != 0);
        }
        return x == newNumber;
    }

    // java Solution.java "121" "true" "-121" "false" "10" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String x = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: x = %s",
                new Solution().isPalindrome(Integer.parseInt(x)), expected, x));
        }
    }
}
