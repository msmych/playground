import java.util.*;

class Solution {

    private final Stack<Character> brackets = new Stack<>();
    private final List<Character> opening = List.of('(', '[', '{'), closing = List.of(')', ']', '}');

    public boolean isValid(String s) {
        for (var c : s.toCharArray()) {
            if (opening.contains(c)) {
                brackets.push(c);
            } else {
                if (brackets.isEmpty()) {
                    return false;
                }
                var b = brackets.peek();
                if (opening.indexOf(b) != closing.indexOf(c)) {
                    return false;
                }
                brackets.pop();
            }
        }
        return brackets.isEmpty();
    }

    // java Solution.java "()" "true" "()[]{}" "true" "(]" "false" "([)]" "false" "{[]}" "true"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().isValid(s), expected, s));
        }
    }
}
