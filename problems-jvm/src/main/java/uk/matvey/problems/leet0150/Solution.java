package uk.matvey.problems.leet0150;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private final List<String> operations = List.of("+", "-", "*", "/");
    private final Deque<Integer> operands = new ArrayDeque<>();

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
}

class SolutionTest {

    @Test
    public void case1() {
        var tokens = new String[]{"2", "1", "+", "3", "*"};

        int result = new Solution().evalRPN(tokens);

        assertThat(result).isEqualTo(9);
    }

    @Test
    public void case2() {
        var tokens = new String[]{"4", "13", "5", "/", "+"};

        int result = new Solution().evalRPN(tokens);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case3() {
        var tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        int result = new Solution().evalRPN(tokens);

        assertThat(result).isEqualTo(22);
    }
}
