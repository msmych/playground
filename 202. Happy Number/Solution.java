import java.util.*;

class Solution {

    public boolean isHappy(int n) {
        var numberSet = new HashSet<Integer>();
        do {
            numberSet.add(n);
            n = next(n);
            if (n == 1) {
                return true;
            } 
        } while (!numberSet.contains(n));
        return false;
    }

    private int next(int n) {
        var sum = 0;
        while (n > 0) {
            var digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }

    // java Solution.java "19" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().isHappy(Integer.parseInt(n)), expected, n));
        }
    }
}
