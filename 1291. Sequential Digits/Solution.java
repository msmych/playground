import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.*;

class Solution {

    private static final String DIGITS = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        return rangeClosed(String.valueOf(low).length(), String.valueOf(high).length())
            .mapToObj(n -> rangeClosed(0, DIGITS.length() - n)
                .mapToObj(i -> DIGITS.substring(i, i + n))
                .map(Integer::parseInt)
                .filter(i -> i >= low)
                .filter(i -> i <= high)
                .collect(toList()))
            .flatMap(List::stream)
            .collect(toList());
    }

    // java Solution.java "100" "300" "[123,234]" "1000" "13000" "[1234,2345,3456,4567,5678,6789,12345]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String low = args[i], high = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: low = %s, high = %s",
                new Solution().sequentialDigits(Integer.parseInt(low), Integer.parseInt(high)), expected, low, high));
        }
    }
}
