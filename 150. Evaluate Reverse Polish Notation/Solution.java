import java.util.*;

class Solution {

    private final List<String> operations = List.of("+", "-", "*", "/");
    private final Stack<Integer> operands = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (var token : tokens) {
            if (operations.contains(token)) {
                operate(token);
            } else {
                operands.push(Integer.valueOf(token));
            }
        }
        return operands.peek();
    }

    private void operate(String operation) {
        var b = operands.peek();
        operands.pop();
        var a = operands.peek();
        operands.pop();
        switch (operation) {
            case "+":
                operands.push(a + b);
                break;
            case "-":
                operands.push(a - b);
                break;
            case "*":
                operands.push(a * b);
                break;
            case "/":
                operands.push(a / b);
        }
    }

    // java Solution.java "[2,1,+,3,*]" "9" "[4,13,5,/,+]" "6" "[10,6,9,3,+,-11,*,/,*,17,+,5,+]" "22"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String tokens = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: tokens = %s",
                new Solution().evalRPN(stringArr(tokens)), expected, tokens));
        }
    }

    private static String[] stringArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        return s.isEmpty() ? new String[0] : s.split(",");
    }
}
