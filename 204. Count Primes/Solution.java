import static java.lang.Math.*;
import static java.util.stream.IntStream.*;
import static java.util.stream.Collectors.*;

class Solution {

    public int countPrimes(int n) {
        var nums = range(2, n).boxed().collect(toSet());
        for (var i = 2; i <= sqrt(n); i++) {
            if (!nums.contains(i)) {
                continue;
            }
            for (var j = 2; j * i <= n; j++) {
                nums.remove(j * i);
            }
        }
        return nums.size();
    }

    // java Solution.java "10" "4"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().countPrimes(Integer.parseInt(n)), expected, n));
        }
    }
}
