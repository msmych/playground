import static java.util.stream.IntStream.rangeClosed;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

class Solution {
    public int countLargestGroup(int n) {
        var sums = rangeClosed(1, n)
            .boxed()
            .collect(groupingBy(this::sumOfDigits, 
                collectingAndThen(counting(), Long::intValue)))
            .values();
        var max = sums.stream().mapToInt(v -> v).max().orElse(0);
        return (int) sums.stream().filter(v -> v == max).count();
    }

    private int sumOfDigits(int n) {
        return (int) String.valueOf(n).chars()
            .map(c -> c - '0')
            .sum();
    }

    // java Solution.java "13" "4" "2" "2" "15" "6" "24" "5"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().countLargestGroup(Integer.parseInt(n)), expected, n));
        }
    }
}
