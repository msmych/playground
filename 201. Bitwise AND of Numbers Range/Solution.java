import java.util.*;

class Solution {
    
    public int rangeBitwiseAnd(int m, int n) {
        if (m < n / 2) {
            return 0;
        }
        var and = m & n;
        var bits = new HashSet<Integer>();
        for (long bit = 1; bit <= and; bit *= 2) {
            if ((and & bit) > 0) {
                bits.add((int) bit);
            }
        }
        for (long i = m; i <= n; i++) {
            if (bits.isEmpty()) {
                return 0;
            }
            var toRemove = new HashSet<Integer>();
            for (var bit : bits) {
                if ((bit & i) == 0) {
                    toRemove.add(bit);
                }
            }
            bits.removeAll(toRemove);
        }
        return bits.stream().reduce((b1, b2) -> b1 | b2).orElse(0);
    }

    // java Solution.java 5 7 "4" 0 1 "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String m = args[i], n = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: m = %s, n = %s",
                new Solution().rangeBitwiseAnd(Integer.parseInt(m), Integer.parseInt(n)), expected, m, n));
        }
    }
}
