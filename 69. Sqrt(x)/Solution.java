class Solution {

    public int mySqrt(int x) {
        int lower = -1, upper = -1, left = 0, right = x/2 + 1, mid;
        while (left <= right) {
            mid = (int) (((long)(right + left)) / 2);
            long square = (long)mid*mid;
            if (square == x) {
                return mid;
            } else if (x > square) {
                lower = mid;
                left = mid + 1;
            } else {
                upper = mid;
                right = mid - 1;
            }
        }
        if (lower != -1 && upper != -1) {
            return lower;
        }
        return -1;
    }

    // java Solution.java "4" "2" "8" "2"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String x = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: x = %s",
                new Solution().mySqrt(Integer.parseInt(x)), expected, x));
        }
    }
}
