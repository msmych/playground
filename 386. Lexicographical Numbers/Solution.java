import java.util.*;

import static java.util.stream.IntStream.*;

class Solution {

    private List<Integer> list = new ArrayList<>();

    private int n;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        rangeClosed(1, 9).forEach(this::next);
        return list;
    }

    private void next(int i) {
        if (i > n) {
            return;
        }
        list.add(i);
        for (var j = 0; j <= 9; j++) {
            next(10 * i + j);
        }
    }

    // java Solution.java "13" "[1,10,11,12,13,2,3,4,5,6,7,8,9]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().lexicalOrder(Integer.parseInt(n)), expected, n));
        }
    }
}
