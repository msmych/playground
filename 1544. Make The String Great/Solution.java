import java.util.*;

import static java.lang.Character.*;
import static java.util.stream.Collectors.*;

class Solution {
    public String makeGood(String s) {
        var stack = new Stack<Character>();
        for (var c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                var last = stack.peek();
                if (toLowerCase(last) == toLowerCase(c) && isLowerCase(last) ^ isLowerCase(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.stream().map(String::valueOf).collect(joining());
    }

    // java Solution.java "leEeetcode" "leetcode" "abBAcC" "" "s" "s"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().makeGood(s), expected, s));
        }
    }
}
