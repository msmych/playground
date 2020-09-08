import java.util.*;

class Solution {

    public int calculate(String s) {
        return calcNext(s.replaceAll(" ", ""));
    }

    private int calcNext(String s) {
        int val = 0, i = s.length() - 1, rightIndex = i;
        while (i >= 0) {
            var c = s.charAt(i);
            if (c == '+') {
                val += Integer.parseInt(s.substring(i + 1, rightIndex + 1));
                rightIndex = --i;
            } else if (c == '-') {
                val -= Integer.parseInt(s.substring(i + 1, rightIndex + 1));
                rightIndex = --i;
            } else if (c == ')') {
                var stack = new Stack<Integer>();
                stack.push(i--);
                rightIndex = i;
                while (!stack.isEmpty()) {
                    if (s.charAt(i) == '(') {
                        rightIndex = stack.pop();
                    } else if (s.charAt(i) == ')') {
                        stack.push(i);
                    }
                    i--;
                }
                var nextVal = calcNext(s.substring(i + 2, rightIndex));
                if (i == -1 || s.charAt(i) == '+') {
                    val += nextVal;
                } else {
                    val -= nextVal;
                }
                rightIndex = --i;
            } else if (i == 0) {
                val += Integer.parseInt(s.substring(0, rightIndex + 1));
                i--;
            } else {
                i--;
            }
        }
        return val;
    }

    // java Solution.java "1 + 1" "2" " 2-1 + 2 " "3" "(1+(4+5+2)-3)+(6+8)" "23"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String s = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: s = %s",
                new Solution().calculate(s), expected, s));
        }
    }
}
