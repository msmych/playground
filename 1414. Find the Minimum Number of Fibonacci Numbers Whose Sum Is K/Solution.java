class Solution {

    public int findMinFibonacciNumbers(int k) {
        if (k < 2) {
            return k;
        }
        int i = 1, j = 1;
        while (j <= k) {
            j += i;
            i = j - i;
        }
        return 1 + findMinFibonacciNumbers(k - i);
    }

    // java Solution.java "7" "2" "10" "2" "19" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String k = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: k = %s",
                new Solution().findMinFibonacciNumbers(Integer.parseInt(k)), expected, k));
        }
    }
}
