import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

class Solution {

    public int longestPalindrome(String s) {
        var oddEven = s.chars().mapToObj(c -> c)
            .collect(groupingBy(c -> c, summingInt(c -> 1)))
            .values().stream()
            .collect(partitioningBy(v -> v % 2 == 0));
        return oddEven.get(false).stream().mapToInt(i -> i).max().orElse(0) + 
            oddEven.get(false).stream().sorted(reverseOrder()).skip(1).mapToInt(i -> i - 1).sum() + 
            oddEven.get(true).stream().mapToInt(i -> i).sum();
    }

    // java Solution.java "abccccdd" "7"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().longestPalindrome(s), expected, s));
        }
    }
}
