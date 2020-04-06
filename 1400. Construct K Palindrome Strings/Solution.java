import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        return s.chars().boxed()
            .collect(groupingBy(c -> c, 
                collectingAndThen(counting(), Long::intValue)))
            .values().stream()
            .filter(n -> n % 2 == 1)
            .count() <= k;
    }

    // java Solution.java "annabelle" "2" "true" "leetcode" "3" "false" "true" "4" "true" "yzyzyzyzyzyzyzy" "2" "true" "cr" "7" "false"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String s = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s, k = %s",
                new Solution().canConstruct(s, Integer.parseInt(k)), expected, s, k));
        }
    }
}
