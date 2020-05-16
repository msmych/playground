import java.util.*;

import static java.util.Collections.*;

class Solution {
    public List<String> simplifiedFractions(int n) {
        if (n < 2) {
            return emptyList();
        }
        var fractions = new ArrayList<String>();
        for (var i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                fractions.add(i + "/" + n);
            }
        }
        fractions.addAll(simplifiedFractions(n - 1));
        return fractions;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            var x = b;
            b = a % b;
            a = x;
        }
        return a;
    }

    // java Solution.java "2" "[1/2]" "3" "[1/2,1/3,2/3]" "4" "[1/2,1/3,1/4,2/3,3/4]" "1" "[]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().simplifiedFractions(Integer.parseInt(n)), expected, n));
        }
    }
}
