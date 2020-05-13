import static java.util.Optional.empty;
import static java.util.stream.Collectors.*;

import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        var stack = new Stack<Character>();
        Optional<Character> last = empty();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            if (i < num.length() - 1) {
                stack.push(num.charAt(i));
            } else {
                last = Optional.of(num.charAt(i));
            }
        }
        while (k-- > 0) {
            if (last.isPresent()) {
                if (stack.isEmpty() || last.get() > stack.peek()) {
                    last = empty();
                } else {
                    stack.pop();
                }
            } else {
                stack.pop();
            }
        }
        last.ifPresent(stack::push);
        var s = stack.stream().dropWhile(c -> c == '0').map(Object::toString).collect(joining());
        return s.isEmpty() ? "0" : s;
    }

    // java Solution.java "1432219" "3" "1219" "10200" "1" "200" "10" "2" "0" 9 1 0 1234567890 9 0
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String num = args[i], k = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: num = %s, k = %s",
                new Solution().removeKdigits(num, Integer.parseInt(k)), expected, num, k));
        }
    }
}
