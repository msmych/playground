import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String getHappyString(int n, int k) {
        return happy('0', n).stream()
            .skip(k - 1)
            .findFirst()
            .orElse("");
    }

    private List<String> happy(char last, int n) {
        if (n == 1) {
            return List.of("a", "b", "c").stream()
                .filter(c -> c.indexOf(last) == -1)
                .collect(Collectors.toList());
        }
        var happy = new ArrayList<String>();
        if (last != 'a') {
            for (var a : happy('a', n - 1)) {
                happy.add('a' + a);
            }
        }
        if (last != 'b') {
            for (var b : happy('b', n - 1)) {
                happy.add('b' + b);
            }
        }
        if (last != 'c') {
            for (var c : happy('c', n - 1)) {
                happy.add('c' + c);
            }
        }
        return happy;
    }

    // java Solution.java "1" "3" "c" "1" "4" "" "3" "9" "cab" "2" "7" "" "10" "100" "abacbabacb"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String n = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s, k = %s",
                new Solution().getHappyString(Integer.parseInt(n), Integer.parseInt(k)), expected, n, k));
        }
    }
}
