class Solution {
    public int numberOfSteps (int num) {
        int steps = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }

    // java Solution.java "14" "6" "8" "4" "123" "12"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String num = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s",
                new Solution().numberOfSteps(Integer.parseInt(num)), expected, num));
        }
    }
}
