import java.util.*;

import static java.lang.Math.*;

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        var isPositive = numerator >= 0 == denominator >= 0;
        long num = abs((long) numerator), den = abs((long) denominator), quot = num / den;
        var remainders = new HashMap<Long, Integer>();
        var sb = new StringBuilder();
        sb.append(quot);
        num %= den;
        if (num != 0) {
            sb.append('.');
        }
        int index = 0, indexAfterPeriod = sb.indexOf(".") + 1;
        while (num != 0) {
            num *= 10;
            quot = abs(num / den);
            if (remainders.containsKey(num)) {
                sb.insert(indexAfterPeriod + remainders.get(num), '(').append(')');
                break;
            } else {
                sb.append(quot);
                remainders.put(num, index++);
            }
            num %= den;
        }
        if (!isPositive) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    // java Solution.java "1" "2" "0.5" "2" "1" "2" "2" "3" "0.(6)"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String numerator = args[i], denominator = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: numerator = %s, denominator = %s",
                new Solution().fractionToDecimal(Integer.parseInt(numerator), Integer.parseInt(denominator)), expected, numerator, denominator));
        }
    }
}
