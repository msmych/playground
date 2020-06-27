class Solution {
    public int lastRemaining(int n) {
        var isLeft = true;
        int head = 1, step = 1;
        while (n > 1) {
            if (isLeft || n % 2 == 1) {
                head += step;
            }
            n /= 2;
            step *= 2;
            isLeft = !isLeft;
        }
        return head;
    }

    // java Solution.java "9" "6"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().lastRemaining(Integer.parseInt(n)), expected, n));
        }
    }
}
