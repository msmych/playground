package uk.matvey.play.leet0150.java1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

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
