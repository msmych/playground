import java.util.*;

class Solution {

    private final Map<Integer, List<String>> cache = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        var parentheses = new ArrayList<String>();
        if (n == 0) {
            parentheses.add("");
        } else {
            for (var i = 0; i < n; i++) {
                for (var left : generateParenthesis(i)) {
                    for (var right : generateParenthesis(n - i - 1)) {
                        parentheses.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache.put(n, parentheses);
        return parentheses;
    }

    // java Solution.java "3" "[((())),(()()),(())(),()(()),()()()]"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String n = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: n = %s",
                new Solution().generateParenthesis(Integer.parseInt(n)), expected, n));
        }
    }
}
