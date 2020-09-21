import java.util.*;

import static java.util.stream.Collectors.*;

class Solution {

    public List<String> findStrobogrammatic(int n) {
        return findNext(n).stream().filter(num -> num.equals("0") || !num.startsWith("0")).collect(toList());
    }

    private List<String> findNext(int n) {
        if (n == 0) {
            return List.of("");
        }
        if (n == 1) {
            return List.of("0", "1", "8");
        }
        return findNext(n - 2).stream()
            .flatMap(num -> List.of('0' + num + '0', '1' + num + '1', '6' + num + '9', '8' + num + '8', '9' + num + '6').stream())
            .collect(toList());
    }


    // java Solution.java "2" "[11,69,88,96]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().findStrobogrammatic(Integer.parseInt(n)), expected, n));
        }
    }
}
